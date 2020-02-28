import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {AccommodationService} from '../../../../Service/admin/accommodation.service';

@Component({
  selector: 'app-accommodation-view',
  templateUrl: './accommodation-view.component.html',
  styleUrls: ['./accommodation-view.component.css']
})
export class AccommodationViewComponent implements OnInit {

  services: any;
  constructor(private categoryService: AccommodationService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.categoryService.getAccommodations()
      .subscribe(res => this.services = res);
  }

  deleteAccommodation(id) {
    this.categoryService.deleteAccommodation(id)
      .subscribe(res => {
          this.ngOnInit();
        }
      );
  }

}
