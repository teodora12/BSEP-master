import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {CertificateService} from '../../../Service/certificate.service';
import {ToastrManager} from 'ng6-toastr-notifications';
import {CertificateStatusService} from '../../../Service/certificate-status.service';
import {UserService} from '../../../Service/user.service';



// @ts-ignore
@Component({
  selector: 'app-certificate-all',
  templateUrl: './certificate-all.component.html',
  styleUrls: ['./certificate-all.component.css']
})
export class CertificateAllComponent implements OnInit {

  certificates: any = [];
  userRole: any;
  user: any;
  constructor(private userService: UserService, private certificateService: CertificateService, private router: Router,
              public toastr: ToastrManager, private certificateStatusServis: CertificateStatusService ) { }

  ngOnInit() {
    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));
    if (userTemp !== null) {
      this.userService.getUserByEmail(userTemp.sub).subscribe(user => {
        this.user = user;
      });
    }
    this.certificateService.getAllCertificate().subscribe(data => {
      this.certificates = data;
      for (const c of this.certificates) {
        c.issuingDate = c.issuingDate.substring(0, 10);
        c.expirationDate = c.expirationDate.substring(0, 10);
      }
    });

  }

  revoke(id) {
    this.certificateStatusServis.revokeCertificate(id).subscribe(data => {
      window.location.reload();
    });

  }


  menageRelations(certificateId) {
    this.router.navigate(['/certificate/relations/', certificateId]);
  }

  checkValidity(certificate, index) {
    const checkCertificate = {keystoreName: certificate.keystore, keystorePassword: certificate.password, certificateId: certificate.id};
    this.certificateService.checkCertificateValidity(checkCertificate).subscribe(isValid => {
      this.toastr.successToastr('Certificate is valid!', 'Valid');
    }, error1 => {
      this.toastr.warningToastr('Certificate is not valid!', 'Not valid');
      certificate.state = 'revoked';
    });
  }


}
