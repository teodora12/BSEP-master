import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  constructor(private http: HttpClient, private router: Router) { }


  getAgent(username): any {
    return this.http.get('agent-service/api/agent/'.concat(username));

  }
}
