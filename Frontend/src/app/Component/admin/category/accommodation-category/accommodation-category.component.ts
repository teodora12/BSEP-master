import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {CategoryService} from '../../../../Service/admin/category.service';

@Component({
  selector: 'app-accommodation-category',
  templateUrl: './accommodation-category.component.html',
  styleUrls: ['./accommodation-category.component.css']
})
export class AccommodationCategoryComponent implements OnInit {

  private services = [];
  constructor(private categoryService: CategoryService, private formBuilder: FormBuilder) { }

  categoryServiceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });
  ngOnInit() {
    this.categoryService.getCategories()
      .subscribe(res => this.services = res);
    console.log(this.categoryService.getCategories() + 'LALALALAL');
    console.log(this.services.length + 'HAHAHAHA');

  }

  addCategoryService() {
    this.categoryService.addCategory(this.categoryServiceForm.value)
      .subscribe(res => {
          this.ngOnInit();
        }
      );
    this.categoryServiceForm.reset();
  }

  deleteCategoryService(categoryServiceId) {
    this.categoryService.deactivateCategory(categoryServiceId)
      .subscribe(res => {
          this.ngOnInit();
        }
      );
  }
}
