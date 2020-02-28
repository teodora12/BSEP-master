import { Component, OnInit } from '@angular/core';
import {AccommodationService} from '../../service/accommodation.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {DomSanitizer} from '@angular/platform-browser';
import {SearchService} from '../../service/search.service';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-accommodation',
  templateUrl: './accommodation.component.html',
  styleUrls: ['./accommodation.component.css']
})
export class AccommodationComponent implements OnInit {

  accommodation: any;
  searchParams: any;
  id: any;
  viewComments = false;
  selectedRooms: any;
  filledCapacity: any;
  enabledRoomSelection: any;
  reservation: any;
  comments = [];
  commentWaiting = [];

  constructor(private accommodationService: AccommodationService, private router: Router, private currentRoute: ActivatedRoute,
              private toastr: ToastrManager, private sanitaizer: DomSanitizer, private searchService: SearchService,
              private userService: UserService) {
    this.accommodation = {picture: [], accommodationType: {}, accommodationCategory: {}};
    this.enabledRoomSelection = true;
    this.filledCapacity = 0;
    this.selectedRooms = [];
    this.reservation = {price: 0, additionalServicesWithPrices: [], numberOfPeople: 0, arrivalDate: Date, departureDate: Date,
      accommodationId: 0, roomIds: []};
  }

  ngOnInit() {
    this.currentRoute.params.subscribe(params => {
      this.accommodationService.getAccommodationById(params.id).subscribe(accommodation => {
        this.accommodation = accommodation;
        this.id = params.id;
        this.reservation.accommodationId = this.accommodation.id;

        for (let i = 0; i < this.accommodation.picture.length; i++) {
          // @ts-ignore
          // first convert byte string to byte array
          const binaryString =  window.atob(this.accommodation.picture[i]);
          const len = binaryString.length;
          const bytes = new Uint8Array( len );
          for (let j = 0; j < len; j++)        {
            bytes[j] = binaryString.charCodeAt(j);
          }
          // @ts-ignore
          const STRING_CHAR = bytes.reduce((data, byte) => {
            return data + String.fromCharCode(byte);
          }, '');
          const base64 = btoa(STRING_CHAR);
          const url = this.sanitaizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64,' + base64);
          this.accommodation.picture[i] = url;
        }
        this.accommodation.room = [];
        this.searchParams = JSON.parse(localStorage.getItem('searchParams'));
        this.reservation.numberOfPeople = this.searchParams.numberOfPersons;
        this.reservation.arrivalDate = this.searchParams.fromDate;
        this.reservation.departureDate = this.searchParams.toDate;

        this.searchParams.accommodationId = params.id;
        this.searchService.searchFreeRooms(this.searchParams).subscribe(rooms => {
          this.accommodation.room = rooms;
          for (let i = 0; i < this.accommodation.room.length; i++) {
            this.accommodation.room[i].reserved = false;
          }
        }, error1 => {
            this.toastr.errorToastr('WRONG FORMAT!', 'Error');

          });
      });
      this.accommodationService.getComments(params.id).subscribe(com => {
        this.comments = com;
        for (let i = 0; i < this.comments.length; i++) {
          if (this.comments[i].status ==='accepted'){
            this.commentWaiting.push(this.comments[i]);
          }
        }

      }) ;
    });
  }

  reserveRoomSelected(room: any, index: any) {

    let loop = new Date(this.searchParams.fromDate);
    while (loop < new Date(this.searchParams.toDate)) {

      for (const i in this.accommodation.pricelist.item) {
        if (loop >= new Date(this.accommodation.pricelist.item[i].startDatePeriod) &&
          loop <= new Date(this.accommodation.pricelist.item[i].endDatePeriod) &&
          room.capacity === this.accommodation.pricelist.item[i].capacity) {
          this.reservation.price = this.reservation.price + this.accommodation.pricelist.item[i].price;
          break;
        }
      }
      const newDate = loop.setDate(loop.getDate() + 1);
      loop = new Date(newDate);

    }

    this.filledCapacity = this.filledCapacity + room.capacity;
    if (this.filledCapacity >= this.searchParams.numberOfPersons) {
      this.enabledRoomSelection = false;
    }
    this.accommodation.room[index].reserved = true;

    this.selectedRooms.push(room);

    this.reservation.roomIds.push(room.id);
  }

  cancelRoomSelected(room: any, index: any) {


    let loop = new Date(this.searchParams.fromDate);
    while (loop < new Date(this.searchParams.toDate)) {

      for (const i in this.accommodation.pricelist.item) {
        if (loop >= new Date(this.accommodation.pricelist.item[i].startDatePeriod) &&
          loop <= new Date(this.accommodation.pricelist.item[i].endDatePeriod) &&
          room.capacity === this.accommodation.pricelist.item[i].capacity) {

          this.reservation.price = this.reservation.price - this.accommodation.pricelist.item[i].price;
          break;
        }
      }
      const newDate = loop.setDate(loop.getDate() + 1);
      loop = new Date(newDate);

    }

    for (let i = 0; i < this.selectedRooms.length; i++) {
      if (this.selectedRooms[i].id === room.id) {

        this.filledCapacity = this.filledCapacity - room.capacity;
        if (this.filledCapacity < this.searchParams.numberOfPersons) {
          this.enabledRoomSelection = true;
        }
        this.accommodation.room[index].reserved = false;
        this.selectedRooms.slice(i, 1);

      }
    }

    for (let i = 0; this.reservation.roomIds.length; i++) {
      if (this.reservation.roomIds[i] === room.id) {
        this.reservation.roomIds.splice(i, 1);
      }
    }

  }

  checkedAdditionalService(additionalServiceWithPrice: any, i: any) {

    let found = false;
    for (let i = 0; i < this.reservation.additionalServicesWithPrices.length; i++) {
      if (this.reservation.additionalServicesWithPrices[i].id === additionalServiceWithPrice.id) {
        this.reservation.additionalServicesWithPrices.splice(i, 1);
        found = true;
        this.reservation.price = this.reservation.price - additionalServiceWithPrice.price;
        break;
      }
    }

    if (!found) {
      this.reservation.additionalServicesWithPrices.push(additionalServiceWithPrice);
      this.reservation.price = this.reservation.price + additionalServiceWithPrice.price;
    }

  }

  reserve() {
    const isLoggedIn = this.userService.isLoggedIn();
    if (isLoggedIn) {
      this.accommodationService.createReservation(this.reservation).subscribe(ret => {
        this.toastr.successToastr('Reservation successfully made', 'Success');
        this.router.navigate(['home']);
      });
    } else {
      this.toastr.errorToastr('You have to log in to make a reservation', 'Login is required');
      this.router.navigate(['login']);
    }
  }

  view() {
    this.viewComments = true;
  }
}
