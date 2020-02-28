import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {AccommodationTypeService} from '../../../../Service/admin/accommodation-type.service';

@Component({
  selector: 'app-accommodation-type',
  templateUrl: './accommodation-type.component.html',
  styleUrls: ['./accommodation-type.component.css']
})
export class AccommodationTypeComponent implements OnInit {

  private services = [];
  constructor(private typeService: AccommodationTypeService, private formBuilder: FormBuilder) { }

  typeServiceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });
  ngOnInit() {
    this.typeService.getTypes()
      .subscribe(res => this.services = res);
  }
  addTypeService() {
    this.typeService.addType(this.typeServiceForm.value)
      .subscribe(res => {
          this.ngOnInit();
        }
      );
    this.typeServiceForm.reset();
  }

  deleteTypeService(typeServiceId) {
    this.typeService.deactivateType(typeServiceId)
      .subscribe(res => {
          this.ngOnInit();
        }
      );
  }
}
