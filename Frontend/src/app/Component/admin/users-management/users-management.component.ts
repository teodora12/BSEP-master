import { Component, OnInit } from '@angular/core';
import {UserManagementServiceService} from '../../../Service/admin/user-management-service.service';

@Component({
  selector: 'app-users-management',
  templateUrl: './users-management.component.html',
  styleUrls: ['./users-management.component.css']
})
export class UsersManagementComponent implements OnInit {

  users: any[];
  agents: any[];
  agent: boolean;
  idField: string;
  companyNumber: number;
  constructor(private userService: UserManagementServiceService) { }

  ngOnInit() {

    this.userService.getUsers()
      .subscribe(res => this.users = res);
    this.userService.getAgents()
      .subscribe(res => this.agents = res);
  }

  ag(id) {
    this.agent = true;
    this.idField = id.toString();
    console.log('jajajajaja' + this.idField);
  }
  agentClick(id) {

    this.userService.saveUser(id, this.companyNumber).subscribe(res => {
      this.ngOnInit();
    });
    this.agent = false;
  }
  activateU(id) {
    this.userService.activateUser(id).subscribe(res => {
      this.ngOnInit();
    });
  }
  deactivateU(id) {
    this.userService.deactivateUser(id).subscribe(res => {
      this.ngOnInit();
    });
  }
  activateA(id) {
    this.userService.activateAgent(id).subscribe(res => {
      this.ngOnInit();
    });
  }
  deactivateA(id) {
    this.userService.deactivateAgent(id).subscribe(res => {
      this.ngOnInit();
    });
  }
  deleteAction(email) {
    this.userService.deleteUsers(email).subscribe(res => {
      this.ngOnInit();
    });
  }
  deleteAgent(email) {
    this.userService.deleteAgents(email).subscribe(res => {
      this.ngOnInit();
    });
  }



}
