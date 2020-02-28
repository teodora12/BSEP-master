import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../service/user.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {JwtHelperService} from '@auth0/angular-jwt';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any;
  token: any;
  wrongUsernameOrPass: boolean;
  jwtHelper: any;

  constructor(private userService: UserService, private router: Router, private toastr: ToastrManager) {
    this.user = {username: '', password: ''};
    this.token = {accessToken: '', expiresIn: ''};
    this.jwtHelper = new JwtHelperService();
  }

  ngOnInit() {

    const isLoggedIn = this.userService.isLoggedIn();
    if (isLoggedIn) {
      this.router.navigate(['home']);
    }

  }
  login() {
    this.wrongUsernameOrPass = false;
    const headers = new Headers();
    this.userService.login(this.user).subscribe(value => {
      headers.append('Authorization', value.headers.get('Authorization'));
      const userFromToken = this.jwtHelper.decodeToken(headers.get('Authorization'));
      userFromToken.token = headers.get('Authorization');
      console.log(userFromToken.roles[0].authority);

      localStorage.setItem('loggedUser', JSON.stringify(userFromToken));
      // this.router.navigate(['/'] );
      location.reload();

    }, error2 => {
      this.wrongUsernameOrPass = true;
      this.toastr.errorToastr('Invalid username or password!', 'Error');
    });
  }

}
