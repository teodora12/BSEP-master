import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  getWaitingComments() {
    return this.http.get<[]>('https://us-central1-bsep-xml.cloudfunctions.net/getAllCommentsForAdmin' );
  }

  manageComment(id: any, status: any) {
    return this.http.get( 'https://us-central1-bsep-xml.cloudfunctions.net/changeStateOfComment?id= '.concat(id)+ '&status='.concat(status) );
  }

  declineComment(commentId) {
    return this.http.delete('user-admin-service/api/comments/delete/'.concat(commentId));
  }

}
