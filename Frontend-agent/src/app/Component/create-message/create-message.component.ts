import { Component, OnInit } from '@angular/core';
import {MessageService} from '../../Service/message.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../Service/user.service';


@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  message: any;
  path: string;
  userUsername: string;
  isSUccess: boolean;
  userRole: any;
  validForService: boolean;
  id: any;
  constructor(private messageService: MessageService, private router: Router,
              public toastr: ToastrManager, private userService: UserService) {

    this.message = {subject: '', content: '', userUsername: '', agentUsername: ''};
  }

  ngOnInit() {
    this.validForService = false;
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    this.message.agentUsername = userTemp.sub;

    this.path = this.router.url;
    this.id = this.path.substring(this.path.lastIndexOf('/') + 1);


    this.userService.findById(this.id).subscribe(user => {
      this.message.userUsername = user.email;
    });




  }


  send(): any {


    if (this.message.subject === '' || this.message.content === '') {
      this.toastr.errorToastr('You must type all data!', 'Error');
      this.validForService = false;
    } else {
      this.validForService = true;
    }

    if ( this.validForService === true) {
      this.messageService.createMessage(this.message).subscribe(success => {

        this.isSUccess = success;
        if (this.isSUccess === true) {
          this.toastr.successToastr('Message is sended', 'Success');

        } else {
          this.toastr.errorToastr('Message is not sended', 'Error');

        }

      }, error1 => {
        this.toastr.errorToastr('WRONG FORMAT!', 'Error');

      });

    }
  }

}
