import { Component, OnInit } from '@angular/core';
import {UserService} from '../../Service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }


  userRole: any;
  user: any;


  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    // if (userTemp !== null) {
    //   this.userService.getUserByEmail(userTemp.sub).subscribe(user => {
    //     this.user = user;
    //   });
    // }
  }

  logout() {
    localStorage.clear();
    this.userRole = '';
    this.router.navigate(['/login']);
  }
}
