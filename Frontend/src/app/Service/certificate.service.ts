import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {

  constructor(private http: HttpClient, private router: Router) { }

  addCertificate(certificate): any {
    return this.http.post('user-admin-service/api/certificate/new', certificate);
  }

  addSelfSignedCertificate(certificate: any) {
    return this.http.post('user-admin-service/api/certificate/self-signed/new', certificate);
  }
  getAllCertificate() {
    // @ts-ignore
    return this.http.get('user-admin-service/api/certificate/all');
  }

  getAllowedRelations(id: any) {
    return this.http.get('user-admin-service/api/certificate/relations/'.concat(id));
  }

  getNotInRelations(id: any) {
    return this.http.get('user-admin-service/api/certificate/relations/new/'.concat(id));
  }

  createNewRelation(relation: any) {
    return this.http.post('user-admin-service/api/certificate/relations/new', relation);
  }

  deleteRelation(relation: any) {
    return this.http.post('user-admin-service/api/certificate/relations', relation);
  }

  checkCertificateValidity(checkCertificate: any) {
    return this.http.post('user-admin-service/api/certificate/validity', checkCertificate);
  }

}
