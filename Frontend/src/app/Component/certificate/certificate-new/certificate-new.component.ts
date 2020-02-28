import { Component, OnInit } from '@angular/core';
import {CertificateService} from '../../../Service/certificate.service';
import {UserService} from '../../../Service/user.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-certificate-new',
  templateUrl: './certificate-new.component.html',
  styleUrls: ['./certificate-new.component.css']
})
export class CertificateNewComponent implements OnInit {

  certificate: any;
  systemsForCombo: any;
  withoutValidForCombo: any;
  userRole: any;
  user: any;

  constructor(private certificateService: CertificateService, private router: Router, public toastr: ToastrManager,
              private userService: UserService) {

  }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    if (userTemp !== null) {
      this.userService.getUserByEmail(userTemp.sub).subscribe(user => {
        this.user = user;
      });
    }
    this.certificate = {
      issuerEmail: '', alias: '', issuedToCommonName: '', surname: '', givenName: '',
      organisation: ' ', organisationalUnit: '', country: '', email: '', validFrom: '', validTo: '', isCA: false,
      keystoreName: '', keystorePassword: ''
    };
    this.systemsForCombo = [];
    this.withoutValidForCombo = [];
    this.getSystems();
    this.getWithoutValid();
  }

  getWithoutValid() {
    this.userService.getUsersWithoutValid().subscribe(withoutValid => {
      // @ts-ignore
      for (const w of withoutValid) {
        this.withoutValidForCombo.push(w.email);
        console.log(this.withoutValidForCombo);
      }
    });
  }

  getSystems() {
    this.userService.getSystems().subscribe(systems => {
      console.log(systems);
      // @ts-ignore
      for (const s of systems) {
        this.systemsForCombo.push(s.email);
      }
    });
  }

  createCertificate() {
    this.certificateService.addCertificate(this.certificate).subscribe(cert => {
      // this.certificate = cert;
      this.toastr.successToastr('Certificate successfully generated!', 'Success');
      this.router.navigate(['/certificate/all']);
    }, err => {
      console.log(err);
      this.toastr.errorToastr('Error while generating certificate!', 'Error');
    });
  }
}
