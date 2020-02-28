import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../../../Service/admin/category.service';

@Component({
  selector: 'app-accommodation-category-edit',
  templateUrl: './accommodation-category-edit.component.html',
  styleUrls: ['./accommodation-category-edit.component.css']
})
export class AccommodationCategoryEditComponent implements OnInit {

  private categoryId;
  private categories = {};
  constructor(private formBuilder: FormBuilder,
              private router: Router, private categoryService: CategoryService,  private route: ActivatedRoute) { }

  serviceForm = this.formBuilder.group({
    name: ['', Validators.required]
  });

  ngOnInit() {
    this.categoryId = this.route.snapshot.paramMap.get('id');
    this.categoryService.getCategory(this.categoryId)
      .subscribe(res => {
        this.categories = res;
      });
  }

  editCategory() {
    this.categoryService.editCategory(this.categoryId, this.serviceForm.value)
      .subscribe(res => {
        this.router.navigate(['category-services']);
      });
  }

}
