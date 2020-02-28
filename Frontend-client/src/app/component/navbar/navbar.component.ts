import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/user.service';
import {AccommodationService} from '../../service/accommodation.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userRole: any;

  constructor(private userService: UserService, private accommodationService: AccommodationService) { }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
  }

  logout() {
    this.userRole = '';
    this.userService.logout();
  }

}
