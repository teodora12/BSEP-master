import { Component, OnInit } from '@angular/core';
import {UserService} from '../../../service/user.service';
import {Router} from '@angular/router';
import {ToastrManager, ToastrModule} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: any;
  repeatedPassword: any;
  match: boolean;
  nameLength: boolean;
  lastNameLength: boolean;

  constructor(private userService: UserService, private router: Router,  public toastr: ToastrManager) {
    this.user = {email: '', password: '', name: '', lastName: ''};
  }

  ngOnInit() {

    const isLoggedIn = this.userService.isLoggedIn();
    if (isLoggedIn) {
      this.router.navigate(['home']);
    }
    this.match = true;
    this.nameLength = true;
    this.lastNameLength = true;
  }

  register(): void {
    this.match = true;
    this.nameLength = true;
    this.lastNameLength = true;

    if (this.user.password !== this.repeatedPassword) {
      this.toastr.errorToastr('Your password did not match. Try again!', 'Error');
      this.match = false;
    }
    if (this.user.name.length > 20) {
      this.toastr.errorToastr('Your name is too long. Try again!', 'Error');
      this.nameLength = false;
    }
    if (this.user.lastName.length > 20) {
      this.toastr.errorToastr('Your last name is too long. Try again!', 'Error');
      this.lastNameLength = false;
    }


    if (this.match === true && this.lastNameLength === true && this.nameLength === true) {
      this.userService.register(this.user).subscribe(newUser => {
        this.user = newUser;

        this.toastr.successToastr('You are registered', 'Success');
        this.router.navigate(['/home'], {});
      }, error => {
        this.toastr.errorToastr('Invalid data!', 'Error');
      });
    }
  }

}
