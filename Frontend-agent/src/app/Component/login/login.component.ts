import { Component, OnInit } from '@angular/core';
import {UserService} from '../../Service/user.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {JwtHelperService} from '@auth0/angular-jwt';
import {AgentService} from '../../Service/agent.service';

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
  isAgent: boolean;
  validForService: boolean;

  constructor(private userService: UserService, private router: Router,  public toastr: ToastrManager, private agentService: AgentService) {
    this.jwtHelper = new JwtHelperService();
  }


  ngOnInit() {
    this.user = {username: '', password: ''};
    this.token = {accessToken: '', expiresIn: ''};
    this.validForService = false;

  }

  login() {


    if (this.user.username === '' || this.user.password === '') {
      this.toastr.errorToastr('You must type all data!', 'Error');
      this.validForService = false;
    } else {
      this.validForService = true;
    }



    if (this.validForService === true) {
      this.agentService.getAgent(this.user.username).subscribe(value => {
        if (value !== null) {
          this.isAgent = true;
        }
      }, error2 => {
        this.wrongUsernameOrPass = true;
        this.toastr.errorToastr('You are not agent or You are not accepted as an agent!', 'Error');
      });


      if (this.isAgent === true) {


        this.wrongUsernameOrPass = false;
        const headers = new Headers();

        this.userService.login(this.user).subscribe(value => {
          headers.append('Authorization', value.headers.get('Authorization'));
          const userFromToken = this.jwtHelper.decodeToken(headers.get('Authorization'));
          userFromToken.token = headers.get('Authorization');
          console.log(userFromToken.roles[0].authority);

          localStorage.setItem('loggedUser', JSON.stringify(userFromToken));
          window.location.reload();
          this.router.navigate(['/home']);
        }, error2 => {
          this.wrongUsernameOrPass = true;
          this.toastr.errorToastr('Invalid username or password!', 'Error');
        });

        this.router.navigate(['/home']);
      }
    }




  }


}
