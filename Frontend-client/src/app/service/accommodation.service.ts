import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AccommodationService {

  baseUrl: string = environment.backend.baseURL;

  constructor(private http: HttpClient) {
  }

  getComments(id: any) {
    return this.http.get<[]>('https://us-central1-bsep-xml.cloudfunctions.net/getCommentsForAccommodation?accommodationId='.concat(id));
  }

  getAccommodationById(id: any) {
    // this.http.options('Headers': ("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT"));

    // return this.http.get(`${this.baseUrl}` + 'user-admin-service/api/accommodation/'.concat(id));
    return this.http.get('user-admin-service/api/accommodation/'.concat(id));
  }


  createReservation(reservationDto: any) {
    return this.http.post('reservation-micro-service/api/reservation', reservationDto);
  }

  addComment(commentDto) {
    return this.http.post('https://us-central1-bsep-xml.cloudfunctions.net/insertCommentForAccommodation', commentDto);
  }

  getAllUserReservations() {
    return this.http.get('reservation-micro-service/api/reservation');
  }

  cancellReservation(id: any) {
    return this.http.delete('reservation-micro-service/api/reservation/'.concat(id));
  }

  getRateForAccommodation(id: any) {
    return this.http.get('https://us-central1-bsep-xml.cloudfunctions.net/getRatingForAccommodation?accommodationId='.concat(id));
  }

  hasUserAlreadyRated(rateDto: any) {
    return this.http.get('https://us-central1-bsep-xml.cloudfunctions.net/hasUserRated?accommodationId='.
    concat(rateDto.accommodationId).concat('&userId=').concat(rateDto.userId), rateDto);
  }

  addRateForAccommodation(rateDto: any) {
    return this.http.post('https://us-central1-bsep-xml.cloudfunctions.net/insertRateForAccommodation', rateDto);
  }
}
