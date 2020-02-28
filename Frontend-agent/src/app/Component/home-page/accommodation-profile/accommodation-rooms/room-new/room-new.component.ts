import { Component, OnInit } from '@angular/core';
import {RoomService} from '../../../../../Service/room.service';
import {Route, Router} from '@angular/router';
import {AccommodationService} from '../../../../../Service/accommodation.service';
import {ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-room-new',
  templateUrl: './room-new.component.html',
  styleUrls: ['./room-new.component.css']
})
export class RoomNewComponent implements OnInit {

  room: any;
  accommodation: any;
  path: string;
  canCreate: boolean;

  constructor(private roomService: RoomService, private router: Router,
              private accommodationService: AccommodationService, private toastr: ToastrManager) {
    this.accommodation = {id: '', name: '', address: '', description: '', accommodationCategory: '', cancellation: '',
      rate: '', agent: '', comments: [], pricelist: '', capacity: '', numberOfPeopleCapacity: '', picture: [],
      room: []};
    this.room = {roomNumber: '', floor: '', capacity: '', accommodationName: ''};
  }

  ngOnInit() {
    this.canCreate = false;
    this.path = this.router.url;
    this.accommodation.id = this.path.substring(this.path.lastIndexOf('/') + 1);

    this.findAccommodation(this.accommodation.id);

  }

  createRoom(room: any): void {

    if (room.roomNumber === '' || room.floor === '' || room.capacity === '') {
      this.toastr.errorToastr('You must type all data!', 'Error');
      this.canCreate = false;
    } else {
      this.canCreate = true;
    }

    if (this.canCreate === true) {
      this.roomService.createRoom(room).subscribe(room => {
        this.room = room;
        this.toastr.successToastr('You created a room !', 'Success');

      }, error => {
        this.toastr.errorToastr('Room number already exsist!', 'Error');
      });
    }

  }

  findAccommodation(id): void {
    this.accommodationService.getAccommodation(id).subscribe(accom => {
      this.accommodation = accom;

      this.room.accommodationName = this.accommodation.name;


    });
  }

}
