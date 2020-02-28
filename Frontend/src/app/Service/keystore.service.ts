import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class KeystoreService {

  constructor(private http: HttpClient, private router: Router) { }

  generateKeystore(keystore: any) {
    return this.http.post('user-admin-service/api/keystore/generate', keystore);
  }
}
