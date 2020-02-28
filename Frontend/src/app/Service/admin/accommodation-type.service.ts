import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AccommodationTypeService {

  constructor(private http: HttpClient) { }
  getTypes() {
    return this.http.get<AccommodationTypeService[]>('user-admin-service/api/accommodationTypes');
  }

  getType(typeId) {
    return this.http.get<AccommodationTypeService>('user-admin-service/api/accommodationTypes/'.concat(typeId));
  }

  addType(data) {
    return this.http.post('user-admin-service/api/accommodationTypes/add', data);
  }

  editType(typeId, data) {
    return this.http.put('user-admin-service/api/accommodationTypes/'.concat(typeId), data);
  }


  deactivateType(typeId) {
    return this.http.delete('user-admin-service/api/accommodationTypes/'.concat(typeId));
  }

}
