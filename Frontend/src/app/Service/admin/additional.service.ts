import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdditionalService {

  id: string;
  constructor(private http: HttpClient, private router: Router) { }

  getAdditionalServices() {
    return this.http.get<AdditionalService[]>('/user-admin-service/api/additional_services');
  }

  getAdditionalService(id: string) {
    return this.http.get<AdditionalService>('/user-admin-service/api/additional_services/'.concat(id));
  }

  addAdditionalService(data) {
    return this.http.post('/user-admin-service/api/additional_services/add', data);
  }

  editAdditionalService(id: string, data) {
    return this.http.put('/user-admin-service/api/additional_services/'.concat(id), data);
  }

  deleteAdditionalService(id: string) {
    return this.http.delete('/user-admin-service/api/additional_services/'.concat(id));
  }
}
