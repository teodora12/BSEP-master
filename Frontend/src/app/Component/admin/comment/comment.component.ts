import { Component, OnInit } from '@angular/core';
import {CommentService} from '../../../Service/admin/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  private comments: any;
  com = [];
  body: any;
  constructor(private commentService: CommentService) { }

  ngOnInit() {

    this.commentService.getWaitingComments()
      .subscribe(res => {
        this.comments = res;

        for(let i = 0; i < this.comments.length; i++){
          if(this.comments[i].status ==='waiting'){
            this.com.push(this.comments[i]);
          }
        }
      }, err => {
        console.log(err);
      });
  }

  approveComment(commentId, i) {
    this.body = { id: commentId, status: 'accepted'};
    this.commentService.manageComment(this.body.id, this.body.status).subscribe(res => {
      this.body = res;
      this.com.splice(i, 1);

    } );

  }

  declineComment(commentId,i) {
    this.body = { id: commentId, status: 'decline'};
    this.commentService.manageComment(this.body.id, this.body.status).subscribe(res => {
      this.body = res;
      this.com.splice(i, 1);
    } );


  }

}
