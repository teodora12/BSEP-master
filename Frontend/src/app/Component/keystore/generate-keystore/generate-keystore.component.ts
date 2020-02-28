import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {KeystoreService} from '../../../Service/keystore.service';
import {ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-generate-keystore',
  templateUrl: './generate-keystore.component.html',
  styleUrls: ['./generate-keystore.component.css']
})
export class GenerateKeystoreComponent implements OnInit {

  keystore: any;

  constructor(private router: Router, private keystoreService: KeystoreService, private toastr: ToastrManager) {
    this.keystore = {name: '', password: ''};
  }

  ngOnInit() {
  }

  generateKeystore() {
    this.keystoreService.generateKeystore(this.keystore).subscribe(ret => {
      this.keystore = ret;
      this.toastr.successToastr('Keystore successfully generated!', 'Success');
      this.router.navigate(['/certificate/all']);
    }, err => {
      console.log(err);
      this.toastr.errorToastr('Error while generating keystore!', 'Error');
    });
  }
}
