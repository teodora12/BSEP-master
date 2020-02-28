import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserManagementServiceService {

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get<[]>('/user-management-micro-service/api/userManagement');
  }

  getAgents() {
    return this.http.get<[]>('/user-management-micro-service/api/agents');
  }

  getAcceptedAgents() {
    return this.http.get('/user-management-micro-service/api/agents/accepted');
  }

  saveUser(id, company: number) {
    return this.http.put('/user-management-micro-service/api/userManagement/save/' + id + '/' + company, null);
  }

  deactivateUser(id) {
    return this.http.put('/user-management-micro-service/api/userManagement/block-user/'.concat(id), null);

  }
  activateUser(id) {
    return this.http.put('/user-management-micro-service/api/userManagement/activate-user/'.concat(id), null);
  }
  deactivateAgent(id) {
    return this.http.put('/user-management-micro-service/api/agents/block-agent/'.concat(id), null);

  }
  activateAgent(id) {
    return this.http.put('/user-management-micro-service/api/agents/activate-agent/'.concat(id), null);
  }
  deleteUsers(email) {
    return this.http.delete('/user-management-micro-service/api/userManagement/delete/'.concat(email));

  }

  deleteAgents(email) {
    return this.http.delete('/user-management-micro-service/api/agents/delete/'.concat(email));

  }
}
