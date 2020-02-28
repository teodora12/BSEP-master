import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {CertificateService} from '../../../Service/certificate.service';
import {UserService} from '../../../Service/user.service';
import {ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-certificate-relations',
  templateUrl: './certificate-relations.component.html',
  styleUrls: ['./certificate-relations.component.css']
})
export class CertificateRelationsComponent implements OnInit {

  relations: any;
  notInRelation: any;
  currentCertificateId: any;
  userRole: any;
  user: any;

  constructor(private userService: UserService, private router: Router, private certificateService: CertificateService,
              private currentRoute: ActivatedRoute, private toastr: ToastrManager) { }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    if (userTemp !== null) {
      this.userService.getUserByEmail(userTemp.sub).subscribe(user => {
        this.user = user;
      });
    }

    this.currentRoute.params.subscribe(params => {
      this.currentCertificateId = params.id;
      this.certificateService.getAllowedRelations(this.currentCertificateId).subscribe(rel => {
        this.relations = rel;
      });
      this.certificateService.getNotInRelations(this.currentCertificateId).subscribe(rel => {
        this.notInRelation = rel;
      });
    });


  }

  allowRelation(user: any, index: any) {
    const relation = {firstUserId: this.currentCertificateId, secondUserId: user.id};
    this.certificateService.createNewRelation(relation).subscribe(rel => {
      this.relations.push(user);
      this.notInRelation.splice(index, 1);
     // window.location.reload();
    }, err => {
      console.log(err);
      this.toastr.errorToastr('Error occurred!', 'Error');
    });
  }

  forbidRelation(user: any, index: any) {

    const relation = {firstUserId: this.currentCertificateId, secondUserId: user.id};
    this.certificateService.deleteRelation(relation).subscribe(rel => {
      this.notInRelation.push(user);
      this.relations.splice(index, 1);
    }, err => {
      console.log(err);
      this.toastr.errorToastr('Error occurred!', 'Error');
    });
  }

}
