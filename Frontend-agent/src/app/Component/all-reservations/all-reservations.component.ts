import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ReservationService} from '../../Service/reservation.service';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../Service/user.service';

@Component({
  selector: 'app-all-reservations',
  templateUrl: './all-reservations.component.html',
  styleUrls: ['./all-reservations.component.css']
})
export class AllReservationsComponent implements OnInit {

  reservations: any;
  reservation: any;
  room: any;
  additionalServices: any;
  paidAdditionalServices: any;
  paidAdditionalService: any;
  accommodationName: any;
  numbersOfRooms: any;
  number: any;
  numberForPush: any;
  reservationId: any;
  canceled: boolean;
  confirmed: boolean;
  userRole: any;

  constructor(private reservationService: ReservationService, private router: Router, public toastr: ToastrManager, private userService: UserService) {
    this.reservation = {price: '', user: '', arrivalDate: '', departureDate: '', status: '', accommodationName: '', roomNumbers: ''};
    this.room = {capacity:  '', roomNumber: '', floor: '', accommodationName: ''};
    this.paidAdditionalService = {price: '' , additionalService: ''};
    this.numberForPush = '';
  }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    this.reservationService.getAllReservations(userTemp.sub).subscribe(reservations => {

      if (reservations.length === 0 || reservations === null) {
        this.toastr.warningToastr('You have no reservations', 'Warning');

      }
      else {
        this.reservations = reservations;
        this.numbersOfRooms = [];
        for (const reservation of this.reservations) {
          const name = reservation.room[0].accommodationName;

          reservation.accommodationName = name;

          reservation.arrivalDate = reservation.arrivalDate.substring(0, 10);
          reservation.departureDate = reservation.departureDate.substring(0, 10);
          this.number = reservation.room.length;
          for (let i = 0; i < this.number; i++) {
            this.numberForPush = reservation.room[i].roomNumber;
            reservation.roomNumbers = this.numberForPush;
          }

          this.additionalServices = reservation.paidAdditionalServices;


        }

      }

    });
  }





  cancel(reservation: any) {

    this.reservationId = reservation.id;

    this.reservationService.cancelReservation(this.reservationId).subscribe(cancel => {
       this.canceled = cancel;

       window.location.reload();
    });

  }


  confirm(reservation: any): void {
    this.reservationId = reservation.id;

    this.reservationService.confirmReservation(this.reservationId).subscribe(confirm => {
      this.confirmed = confirm;
      window.location.reload();
    });


  }

}


