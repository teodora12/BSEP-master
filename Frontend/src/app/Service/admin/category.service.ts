import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getCategories() {
    return this.http.get<CategoryService[]>('/user-admin-service/api/categories');
  }

  getCategory(categoryId) {
    return this.http.get<CategoryService>('/user-admin-service/api/categories/'.concat(categoryId));
  }

  addCategory(data) {
    return this.http.post('/user-admin-service/api/categories/add', data);
  }

  editCategory(categoryId, data) {
    return this.http.put('/user-admin-service/api/categories/'.concat(categoryId), data);
  }


  deactivateCategory(categoryId) {
    return this.http.delete('/user-admin-service/api/categories/'.concat( categoryId));
  }}
