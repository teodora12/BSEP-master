import { Component, OnInit } from '@angular/core';
import {RoomService} from "../../../../../Service/room.service";
import {Router} from "@angular/router";
import {AccommodationService} from "../../../../../Service/accommodation.service";
import {ToastrManager} from "ng6-toastr-notifications";

@Component({
  selector: 'app-room-update',
  templateUrl: './room-update.component.html',
  styleUrls: ['./room-update.component.css']
})
export class RoomUpdateComponent implements OnInit {

  room: any;
  accommodation: any;
  path: string;
  list: any[];
  canUpdate: boolean;

  constructor(private roomService: RoomService, private router: Router,
              private accommodationService: AccommodationService, private toastr: ToastrManager) {
    this.accommodation = {id:'', name: '', address:'', description: '', accommodationCategory:'', cancellation: '',
      rate:'', agent:'', comments:[], pricelist: '', capacity:'', numberOfPeopleCapacity:'', picture:[],
      room:[]};
    this.room = {roomNumber:'', floor: '', capacity: '', accommodationName:'', roomId: '', newRoomNumber: ''};
  }

  ngOnInit() {
    this.canUpdate = false;
    this.path = this.router.url;

    this.list = this.path.split('/');

    this.room.roomNumber = this.list[4];
    this.room.roomId = this.list[5];

  }

  updateRoom(room: any) : void{
    if(room.newRoomNumber === '' || room.floor === '' || room.capacity === ''){
      this.toastr.errorToastr('You must type all data!', 'Error');
      this.canUpdate = false;
    }
    else {
      this.canUpdate = true;
    }

   if(this.canUpdate === true){

      this.roomService.updateRoom(room).subscribe(room =>{
        this.room = room;
        this.toastr.successToastr('You updated a room !', 'Success');


      }, error1 => {
        this.toastr.errorToastr('Room number already exsist!', 'Error');
      });
    }

  }


}
