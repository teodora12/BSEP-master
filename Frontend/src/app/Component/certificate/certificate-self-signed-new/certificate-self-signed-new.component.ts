import { Component, OnInit } from '@angular/core';
import {CertificateService} from '../../../Service/certificate.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../../Service/user.service';

@Component({
  selector: 'app-certificate-self-signed-new',
  templateUrl: './certificate-self-signed-new.component.html',
  styleUrls: ['./certificate-self-signed-new.component.css']
})
export class CertificateSelfSignedNewComponent implements OnInit {

  certificate: any;
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
    this.certificate = {issuerEmail: '', alias: '', issuedToCommonName: '', surname: '', givenName: '',
      organisation: ' ', organisationalUnit: '', country: '', email: '', validFrom: Date, validTo: Date,
      keystoreName: '', keystorePassword: ''};
    this.withoutValidForCombo = [];
    this.getWithoutValid();
  }


  getWithoutValid() {
    this.userService.getUsersWithoutValid().subscribe( withoutValid => {
      // @ts-ignore
      for (const w of withoutValid) {
        this.withoutValidForCombo.push(w.email);
        console.log(this.withoutValidForCombo);
      }
    } );
  }
  createCertificate() {
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));

    // this.certificate.issuerEmail = userTemp.sub;
    this.certificate.issuerEmail = this.certificate.email;
    this.certificateService.addSelfSignedCertificate(this.certificate).subscribe( cert => {
      this.certificate = cert;
      this.toastr.successToastr('Certificate successfully generated!', 'Success');
      this.router.navigate(['/certificate/all']);
    }, err => {
      console.log(err);
      this.toastr.errorToastr('Error while generating certificate!', 'Error');
    });
  }

}

