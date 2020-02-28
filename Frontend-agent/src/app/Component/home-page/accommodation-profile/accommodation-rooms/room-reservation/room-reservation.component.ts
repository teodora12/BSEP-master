import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ReservationService} from '../../../../../Service/reservation.service';
import {NgbDate} from '@ng-bootstrap/ng-bootstrap';
import {RoomService} from '../../../../../Service/room.service';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../../../../Service/user.service';


@Component({
  selector: 'app-room-reservation',
  templateUrl: './room-reservation.component.html',
  styleUrls: ['./room-reservation.component.css']
})
export class RoomReservationComponent implements OnInit {

  reservation: any;
  path: string;
  list: any[];

  hoveredDate: NgbDate;
  pickUpDate: NgbDate;
  dropOffDate: NgbDate;
  pickUpTime: string;
  dropOffTime: string;

  numberOfDays: number;
  one_day: any;
  date1_ms: any;
  date2_ms: any;
  difference_ms: any;
  userRole: any;
  user: any;
  room: any;

  constructor(private router: Router, private reservationService: ReservationService, private roomService: RoomService,
              private toastr: ToastrManager, private userService: UserService) {
    this.reservation = {agentUsername: '', startDate: Date, endDate: Date, accommodationName: '', roomId: ''};
    this.room = {id: '', roomNumber: '', floor: '', capacity: '', accommodationName: ''};

  }

  ngOnInit() {

    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));

    this.path = this.router.url;



    this.reservation.roomId = this.path.substring(this.path.lastIndexOf('/') + 1);
    this.reservation.agentUsername = userTemp.sub;
    console.log(this.reservation.agentUsername);

    this.findRoomById(this.reservation.roomId);


  }



  reserve(): void {


    let hours = '0';
    let minutes = '0';

    if (this.pickUpTime === undefined) {
      this.toastr.errorToastr('You must pick arrival time!', 'Error');
    }


    console.log(this.pickUpTime);
    console.log(this.dropOffTime);

    hours = this.pickUpTime.split(':')[0];
    minutes = this.pickUpTime.split(':')[1];


    let x = +hours[0];      // radi pretvaranje stringa u broj
    let y = +minutes[0];


    this.reservation.startDate = new Date(Date.UTC(this.pickUpDate.year, this.pickUpDate.month - 1, this.pickUpDate.day,
      x, y, 0, 0));

    hours = '0';
    minutes = '0';

    if (this.dropOffTime === undefined) {
      this.toastr.errorToastr('You must pick departure time!', 'Error');
    }

    hours = this.dropOffTime.split(':')[0];
    minutes = this.dropOffTime.split(':')[1];

    x = +hours[0];      // radi pretvaranje stringa u broj
    y = +minutes[0];

    this.reservation.endDate = new Date(Date.UTC(this.dropOffDate.year, this.dropOffDate.month - 1, this.dropOffDate.day,
      x, y, 0, 0));

    this.inBetween();

    this.reserveRoom(this.reservation);




  }



    findRoomById(id): void {
      this.roomService.getRoom(id).subscribe(room => {
        this.room = room;
        this.reservation.accommodationName = this.room.accommodationName;
      });
    }


    reserveRoom(reservation: any): void {
    this.reservationService.reserveRoom(reservation).subscribe(res => {
      this.reservation = res;

      this.toastr.successToastr('You reserved a room !', 'Success');


    }, error1 => {
      this.toastr.errorToastr('Reservation for this period exsists!', 'Error');

    });
  }

  inBetween() {
    this.one_day = 1000 * 60 * 60 * 24;
    this.date1_ms = this.reservation.startDate.getTime();
    this.date2_ms = this.reservation.endDate.getTime();

    this.difference_ms = this.date2_ms - this.date1_ms;
    this.numberOfDays = Math.round((this.difference_ms / this.one_day) + 1);
  }


  onDateSelect($event) {
    if (!this.pickUpDate && !this.dropOffDate) {
      this.pickUpDate = $event;
    } else if (this.pickUpDate && !this.dropOffDate && $event.after(this.pickUpDate)) {
      this.dropOffDate = $event;
    } else {
      this.dropOffDate = null;
      this.pickUpDate = $event;
    }
  }

  isHovered(date: NgbDate) {
    return this.pickUpDate && !this.dropOffDate &&
      this.hoveredDate && date.after(this.pickUpDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.pickUpDate) && date.before(this.dropOffDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.pickUpDate) || date.equals(this.dropOffDate)
      || this.isInside(date) || this.isHovered(date);
  }

}
