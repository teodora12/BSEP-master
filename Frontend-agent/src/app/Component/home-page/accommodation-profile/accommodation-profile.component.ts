import { Component, OnInit } from '@angular/core';
import {AccommodationService} from '../../../Service/accommodation.service';
import {Router} from '@angular/router';
import {RoomService} from '../../../Service/room.service';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../../Service/user.service';

@Component({
  selector: 'app-accommodation-profile',
  templateUrl: './accommodation-profile.component.html',
  styleUrls: ['./accommodation-profile.component.css']
})
export class AccommodationProfileComponent implements OnInit {

  accommodation: any;
  path: string;
  reservation: any;
  list: any[];
  comment: any;
  user: any;
  accommodationCategory: string;
  userRole: any

  constructor(private accommodationService: AccommodationService, private router: Router,
              private roomService: RoomService, private toastr: ToastrManager, private userService: UserService) {
    this.accommodation = {id: '', name: '', address: { city: '', country: '', street: '', streetNumber: ''}, description: '',
      accommodationCategory: {name: ''}, cancellation: {isEnabled: '', days: ''}, rate: '', agent: '',
      comments: [], pricelist: { item : [{startDatePeriod: Date, endDatePeriod: Date, price: '', capacity: ''}]},
      capacity: '', numberOfPeopleCapacity: '', picture: [], room: [], accommodationType: {name: ''},
      additionalServiceWithPrices:  [{price: '', additionalServices: {name: ''} } ] };
    this.reservation = {agentUsername: '', startDate: '', endDate: '', accommodationName: '', roomId: ''};
    this.comment = {status: '', content: '', user : {email: '', name: ''}, id : ''};

  }



  ngOnInit() {

    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));

    this.path = this.router.url;
    this.accommodation.id = this.path.substring(this.path.lastIndexOf('/') + 1);

    this.reservation.agentUsername = userTemp.sub;
    console.log(this.reservation.agentUsername);
    this.findAccommodation(this.accommodation.id);
  }

  findAccommodation(id): void {
      this.accommodationService.getAccommodation(id).subscribe(accom => {



        this.accommodation = accom;
        this.accommodationCategory = this.accommodation.accommodationCategory.name;
        console.log(this.accommodationCategory);

        if (this.accommodation.cancellation.isEnabled === true) {
          this.accommodation.cancellation.isEnabled = 'possible';
        } else {
          this.accommodation.cancellation.isEnabled = 'not possible';
        }

        for(const item of this.accommodation.pricelist.item) {

          item.startDatePeriod = item.startDatePeriod.substring(0, 10);
          item.endDatePeriod = item.endDatePeriod.substring(0, 10);
        }

      });
  }

  deleteRoom(room: any): void {
    this.roomService.deleteRoom(room.id).subscribe(status => {
         this.toastr.successToastr('Room deleted!', 'Success');
         window.location.reload();
         console.log(status);
    }, error1 => {
      this.toastr.errorToastr('Reservations for this room exsist!', 'Error');
    });
  }

  newRoomWithAccommodationName(accommodation: any): void {
    this.router.navigate(['/accommodation/room/new', accommodation.id]);
  }

  updateRoom(room: any): void {
    this.router.navigate(['/accommodation/room/update/'.concat(room.roomNumber).concat('/').concat(room.id)]);
  }

  reserveRoom(room: any): void {
    this.router.navigate(['/accommodation/reservation/'.concat(room.id)]);
  }

}
