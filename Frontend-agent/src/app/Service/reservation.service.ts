import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient, private router: Router) { }


  getAllReservations(username): any {
    return this.http.get('agent-service/api/reservation/agent/'.concat(username));
  }

  cancelReservation(reservationId): any {
    // @ts-ignore
    return this.http.put('/agent-service/api/reservation/cancel/'.concat(reservationId));

  }

  confirmReservation(reservationId): any {
    // @ts-ignore
    return this.http.put('/agent-service/api/reservation/confirm/'.concat(reservationId));

  }

  reserveRoom(reservation: any){
    return this.http.post('agent-service/api/reservation/create',reservation);
  }

}
