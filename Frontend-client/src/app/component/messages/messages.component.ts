import { Component, OnInit } from '@angular/core';
import {MessageService} from '../../service/message.service';
import {UserService} from '../../service/user.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  messages: [{subject: string, content: string, dateOfSending: string, agentUsername: string }];

  constructor(private userService: UserService) { }

  ngOnInit() {

    this.userService.getAllMessages().subscribe( mes => {
      // @ts-ignore
      this.messages = mes;
      this.messages.sort((a, b) => {
        if (new Date(a.dateOfSending) < new Date(b.dateOfSending)) {
          return -1;
        } else if (new Date(a.dateOfSending) > new Date(b.dateOfSending)) {
          return 1;
        } else {
          return 0;
        }
      });
    });
  }

}
