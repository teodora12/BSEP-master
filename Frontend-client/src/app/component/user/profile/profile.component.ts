import { Component, OnInit } from '@angular/core';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../../service/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userRole: any;
  user: any;
  changePassword: any;
  oldPassword: any;
  newPassword: any;
  confirmPassword: any;

  constructor(private userService: UserService, private toastr: ToastrManager) { }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    this.userService.getUserByUsername(userTemp.sub).subscribe( user => {
      this.user = user;
      this.changePassword = false;
    });
  }

  save() {
    this.userService.updateUser(this.user).subscribe(u => {
      this.user = u;
    }, error1 => {
      this.toastr.errorToastr('Error during info update', 'Error');
    });
  }

  showChangePassword() {
    this.changePassword = true;
  }

  passwordChanged() {
    if (this.newPassword === this.confirmPassword) {
      if (this.newPassword !== '' && this.oldPassword !== '') {
        this.changePassword = false;
        // this.userService.updateUser(this.user).subscribe(u => {
        //   this.user = u;
        // });
        const passwordChanger = { oldPassword: this.oldPassword, newPassword: this.newPassword };
        // this.userService.changePassword(passwordChanger).subscribe(newp => {
        //   this.user.password = newp;
        // });
        this.toastr.successToastr('Password successfully changed', 'Success');
      } else {
        this.toastr.warningToastr('Password cant be empty', 'Warning');
      }
    } else {
      this.toastr.errorToastr('Passwords are not matching', 'Wrong repeated password');
    }
  }

  cancelPasswordChange() {
    this.changePassword = false;
  }

}
