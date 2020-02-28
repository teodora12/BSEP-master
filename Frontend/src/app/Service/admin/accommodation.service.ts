import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  constructor(private http: HttpClient) { }

  getAccommodations() {
    return this.http.get('user-admin-service/api/accommodation');
  }
  addAccommodation(apartment) {
    console.log(apartment);
    return this.http.post('user-admin-service/api/accommodation/create', apartment);
  }

  editAccommodation(apartment) {
    console.log(apartment);
    return this.http.put('user-admin-service/api/accommodation/update', apartment);
  }

  editItem(item) {
    console.log(item);
    return this.http.put('user-admin-service/api/accommodation/editItems', item);
  }

  deleteAccommodation(id) {
    return this.http.delete( 'user-admin-service/api/accommodation/'.concat(id));
  }

  deleteItem(id) {
    return this.http.delete( 'user-admin-service/api/accommodation/deleteItem/'.concat(id));

  }

  getAccommodation(id: number) {
      return this.http.get<AccommodationService>('user-admin-service/api/accommodation/' + id);
  }


}
