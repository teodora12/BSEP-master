import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http: HttpClient, private router: Router) { }



  getAllMessages(username): any {
    return this.http.get('/agent-service/api/message/all/'.concat(username));
  }

  createMessage(message): any {
    return this.http.post('/agent-service/api/message/create', message);
  }

}
