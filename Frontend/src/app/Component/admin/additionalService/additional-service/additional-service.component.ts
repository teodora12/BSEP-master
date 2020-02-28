import { Component, OnInit } from '@angular/core';
import {AdditionalService} from '../../../../Service/admin/additional.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-additional-service',
  templateUrl: './additional-service.component.html',
  styleUrls: ['./additional-service.component.css']
})
export class AdditionalServiceComponent implements OnInit {

  private services = [];
  constructor(private additionalService: AdditionalService, private formBuilder: FormBuilder) { }


  additionalServiceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });
  ngOnInit() {
    this.additionalService.getAdditionalServices()
      .subscribe(res => this.services = res);
  }

  addAdditionalService() {
    this.additionalService.addAdditionalService(this.additionalServiceForm.value)
      .subscribe(res => {
        this.ngOnInit();
      }
      );
    this.additionalServiceForm.reset();
  }

  deleteAdditionalService(additionalServiceId) {
    this.additionalService.deleteAdditionalService(additionalServiceId)
      .subscribe(res => {
        this.ngOnInit();
      }
      );
  }
}
