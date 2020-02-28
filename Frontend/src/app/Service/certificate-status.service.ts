import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CertificateStatusService {

  constructor(private http: HttpClient, private router: Router) { }

  revokeCertificate(id) {
    console.log(id);

    return this.http.get('user-admin-service/api/certificateStatus/revoke/'.concat(id));
  }
}
