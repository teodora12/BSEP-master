import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  getLoggedUserType() {
    const user = JSON.parse(localStorage.getItem('loggedUser'));
    let userRole;
    if (user === null) {
      userRole = '';
    } else {
      for (const role of user.roles) {
        if (role === 'ROLE_USER') {
          userRole = 'ROLE_USER';
        }
      }
    }
    return userRole;
  }

  login(user): any {
    return this.http.post('user-admin-service/api/auth/login', user, {observe: 'response'}).pipe(map(response => response));
  }

  register(user): any {
    return this.http.post('user-admin-service/api/users/register', user);
  }

  isLoggedIn() {
    const user = JSON.parse(localStorage.getItem('loggedUser'));

    if (user === null) {
      return false;
    }
    const expiredDate = new Date(new Date(parseInt(user.exp, 10) * 1000));
    const nowDate = new Date();
    if ((expiredDate.getDate() <= nowDate.getDate()) &&
      (expiredDate.getTime() <= nowDate.getTime())) {
      this.logout();
      return false;
    }
    return true;

  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  getToken(): string {
    const currentUser = JSON.parse(localStorage.getItem('loggedUser'));
    if (currentUser !== null) {
      currentUser.token = currentUser.token.replace(':', '');
    }
    const token = currentUser && currentUser.token;
    return token ? token : '';
  }

  getUserByUsername(email: any) {
    return this.http.get('user-admin-service/api/users/'.concat(email));
  }

  updateUser(user: any) {
    return this.http.put('user-admin-service/api/users', user);
  }


  sendMessage(message: any) {
    return this.http.post('user-admin-service/api/message', message);
  }

  getAllMessages() {
    return this.http.get('user-admin-service/api/message/getAll');
  }
}
