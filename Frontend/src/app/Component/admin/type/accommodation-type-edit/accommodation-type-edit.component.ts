import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AccommodationTypeService} from '../../../../Service/admin/accommodation-type.service';

@Component({
  selector: 'app-accommodation-type-edit',
  templateUrl: './accommodation-type-edit.component.html',
  styleUrls: ['./accommodation-type-edit.component.css']
})
export class AccommodationTypeEditComponent implements OnInit {

  private typeId;
  private types = {};
  constructor(private formBuilder: FormBuilder,
              private router: Router, private typeService: AccommodationTypeService,  private route: ActivatedRoute) { }

  serviceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });
  ngOnInit() {
    this.typeId = this.route.snapshot.paramMap.get('id');
    this.typeService.getType(this.typeId)
      .subscribe(res => {
        this.types = res;
      });
  }
  editType() {
    this.typeService.editType(this.typeId, this.serviceForm.value)
      .subscribe(res => {
        this.router.navigate(['type-services']);
      });
  }

}
