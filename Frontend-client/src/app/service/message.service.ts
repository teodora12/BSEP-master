import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable, Subject} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private subject;

  constructor() {
    this.subject = new BehaviorSubject('');
  }


  sendMessage(message: any) {
    this.subject.next(message);
    const ret = {value: 'Message written'};
    return this.subject;
  }

  clearMessage() {
    this.subject.next('');
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }

}
