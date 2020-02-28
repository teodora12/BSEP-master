import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AdditionalService} from '../../../../Service/admin/additional.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
  selector: 'app-additonal-service-edit',
  templateUrl: './additonal-service-edit.component.html',
  styleUrls: ['./additonal-service-edit.component.css']
})
export class AdditonalServiceEditComponent implements OnInit {


  private additionalServiceId;
  private additionalService = {};

  constructor(private formBuilder: FormBuilder,
              private router: Router, private additionalServicesService: AdditionalService,  private route: ActivatedRoute) { }

  serviceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });

  ngOnInit() {
    this.additionalServiceId = this.route.snapshot.paramMap.get('id');
    this.additionalServicesService.getAdditionalService(this.additionalServiceId)
      .subscribe(res => {
        this.additionalService = res;
      });
  }

  editAdditionalService() {
    this.additionalServicesService.editAdditionalService(this.additionalServiceId, this.serviceForm.value)
      .subscribe(res => {
        this.router.navigate(['additional-services']);
      });
  }

}
