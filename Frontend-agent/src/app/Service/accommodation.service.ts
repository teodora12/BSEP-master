import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  constructor(private http: HttpClient) { }

  getAccommodations() {
    return this.http.get('agent-service/api/accommodation');
  }

  getAccommodation(id: string) {
    return this.http.get('agent-service/api/accommodation/'.concat(id));
  }

  getAccommodationsByAgent(username: string) {
    return this.http.get('agent-service/api/accommodation/agent/'.concat(username));
  }

  getCommentsForAcc(id) {
    return this.http.get('https://us-central1-bsep-xml.cloudfunctions.net/getCommentsForAccommodation?accommodationId='.concat(id));
  }

  getRateForAcc(id) {
    return this.http.get('https://us-central1-bsep-xml.cloudfunctions.net/getRatingForAccommodation?accommodationId='.concat(id));
  }

}
