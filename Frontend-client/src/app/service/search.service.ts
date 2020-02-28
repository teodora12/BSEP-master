import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  getAdditionalServices() {
    return this.http.get('user-admin-service/api/additional_services');
  }

  getAccommodationCategories() {
    return this.http.get('user-admin-service/api/categories');
  }

  getAccommodationTypes() {
    return this.http.get('user-admin-service/api/accommodationTypes');
  }

  searchAccommodation(searchObj: any) {
    return this.http.post('search-micro-service/api/search', searchObj);
  }

  searchFreeRooms(searchObj: any) {
    return this.http.post('search-micro-service/api/search/rooms', searchObj);
  }
}
