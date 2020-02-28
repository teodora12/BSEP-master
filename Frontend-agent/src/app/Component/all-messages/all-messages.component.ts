import { Component, OnInit } from '@angular/core';
import {MessageService} from '../../Service/message.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../Service/user.service';

@Component({
  selector: 'app-all-messages',
  templateUrl: './all-messages.component.html',
  styleUrls: ['./all-messages.component.css']
})
export class AllMessagesComponent implements OnInit {

  messages: any;
  message: any;
  listMessages: any;
  userRole: any;


  constructor(private messageService: MessageService, private router: Router, public toastr: ToastrManager, private userService: UserService) {
   this.message = {dateOfSending: '', content: '', user: '', subject: ''};
  }

  ngOnInit() {

    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));

    this.messageService.getAllMessages(userTemp.sub).subscribe(meessages => {
      this.messages = meessages;
      if (this.messages.length === 0) {
        this.toastr.warningToastr('You have no messages', 'Warning');

      } else {
      this.listMessages = [];
      for (const message of this.messages) {
        message.dateOfSending = message.dateOfSending.substring(0, 10);
        this.listMessages.push(message);
      }

     }
        });


  }



  deleteMessage(message): void {
  //   this.carServiceService.deleteCarService(carService.id).subscribe(status => {
  //     this.toastr.successToastr('Car service deleted', 'Success');
  //     this.refresh();
  //   }, error1  => {
  //     this.toastr.errorToastr('Car service has car/s which is in use!', 'Error');
  //   });
  // }
  // refresh(): void {
  //   window.location.reload();
  }


}
