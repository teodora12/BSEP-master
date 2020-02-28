import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }

  deleteRoom(id: string){
    return this.http.delete('agent-service/api/room/delete/'.concat(id));
  }

  createRoom(room: any){
    return this.http.post('agent-service/api/room/create',room);
  }

  updateRoom(room: any){
    return this.http.put('agent-service/api/room/update',room);
  }

  getRoom(id: any){
    return this.http.get('agent-service/api/room/get/'.concat(id));
  }

}
