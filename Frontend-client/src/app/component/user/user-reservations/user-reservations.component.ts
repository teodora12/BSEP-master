import { Component, OnInit } from '@angular/core';
import {AccommodationService} from '../../../service/accommodation.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../../service/user.service';

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.css']
})
export class UserReservationsComponent implements OnInit {

  reservations: any;
  reservation: any;   // za poruku da znm za koju rez
  messageView: boolean;
  userId: number;
  userName: any;
  userLastName: any;

  constructor(private accommodationService: AccommodationService, private router: Router, private toastr: ToastrManager,
              private userService: UserService) {
    this.reservations = [{accommodation: {name: '', address: {city: '', country: ''}}, room: [], paidAdditionalServices: []}];
    this.messageView = false;
    this.userId = 0;
  }

  ngOnInit() {

    this.accommodationService.getAllUserReservations().subscribe(res => {
      this.reservations = res;
      const today = new Date();
      for (let i = 0; i < this.reservations.length; i++) {
        this.accommodationService.getAccommodationById(this.reservations[i].accommodationId).subscribe(acc => {
          this.reservations[i].accommodation = acc;
        });

        this.reservations[i].cancellationEnabled = false;
        this.reservations[i].hasRated = true;
        if (this.reservations[i].numberOfDaysForCancellation > 0) {
          const arrivalDate = new Date(this.reservations[i].arrivalDate);
          const leftDays = this.reservations[i].numberOfDaysForCancellation;
          arrivalDate.setDate(arrivalDate.getDate() - leftDays);
          if (arrivalDate > today) {
            this.reservations[i].cancellationEnabled = true;
          }
        }

        this.reservations[i].commentsEnabled = false;
        const departureDate = new Date(this.reservations[i].departureDate);
        if (departureDate < today) {
          this.reservations[i].commentsEnabled = true;

          const currentUser = JSON.parse(localStorage.getItem('loggedUser'));
          if (currentUser !== null) {
            this.userService.getUserByUsername(currentUser.sub).subscribe(user => {

              this.userId = user['id'];
              this.userName = user['name'];
              this.userLastName = user['lastName'];
              const rateDto = {accommodationId: this.reservations[i].accommodationId, userId: user['id']};
              this.accommodationService.hasUserAlreadyRated(rateDto).subscribe(hasRated => {
                this.reservations[i].hasRated = hasRated;
              }, error1 => {
                console.log(error1);
              });
            });
          }
        }
      }
    });
  }

  cancellReservation(reservation: any, index: any) {
    this.accommodationService.cancellReservation(reservation['id']).subscribe(res => {
      this.reservations.splice(index, 1);
      this.toastr.successToastr('Reservation is successfully cancelled', 'Success');
    });
  }

  submitComment(reservation: any) {
    if (this.userId === 0) {
      const currentUser = JSON.parse(localStorage.getItem('loggedUser'));
      if (currentUser !== null) {
        this.userService.getUserByUsername(currentUser.sub).subscribe(user => {
          this.userId = user['id'];
          this.userName = user['name'];
          this.userLastName = user['lastName'];
          const commentDto = {accommodationId: reservation.accommodation.id, userId: this.userId, content: reservation.comment,
            userName: this.userName, userLastName: this.userLastName, status: 'waiting'};
          this.accommodationService.addComment(commentDto).subscribe(res => {
            this.toastr.successToastr('Comment submited', 'Success');
          });
        });
      }
    } else {
      const commentDto = {accommodationId: reservation.accommodation.id, userId: this.userId, content: reservation.comment,
        userName: this.userName, userLastName: this.userLastName, status: 'waiting'};
      this.accommodationService.addComment(commentDto).subscribe(res => {
        this.toastr.successToastr('Comment submited', 'Success');
      });
    }
  }

  openMessageView(reservation: any) {
    this.messageView = true;
    this.reservation = reservation;
  }

  sendMessage(reservation: any) {
    const message = {subject: reservation.subject, content: reservation.message, accommodationId: reservation.accommodationId};
    this.userService.sendMessage(message).subscribe(ret => {
      this.reservation = {};
      this.toastr.successToastr('Message successfully sent', 'Success');
      this.messageView = false;
    }, error1 => {
      this.toastr.errorToastr('WRONG FORMAT!', 'Error');

    });

  }

  rateAccommodation(reservation: any, index: any) {
    if (this.userId === 0) {
      const currentUser = JSON.parse(localStorage.getItem('loggedUser'));
      if (currentUser !== null) {
        this.userService.getUserByUsername(currentUser.sub).subscribe(user => {
          this.userId = user['id'];
          this.userName = user['name'];
          this.userLastName = user['lastName'];
          const rateDto = {accommodationId: reservation.accommodationId, userId: this.userId, value: reservation.addRating};
          this.accommodationService.addRateForAccommodation(rateDto).subscribe(ret => {
            this.reservations[index].hasRated = true;
          });
        });
      }
    } else {
      const rateDto = {accommodationId: reservation.accommodationId, userId: this.userId, value: reservation.addRating};
      this.accommodationService.addRateForAccommodation(rateDto).subscribe(ret => {
        this.reservations[index].hasRated = true;
      });
    }
  }

}
