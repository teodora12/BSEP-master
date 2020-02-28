import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './Component/users/register/register.component';
import {HomeComponent} from './Component/home/home.component';
import {FormsModule} from '@angular/forms';
import {LogInComponent} from './Component/users/log-in/log-in.component';
import {CertificateNewComponent} from './Component/certificate/certificate-new/certificate-new.component';
import {GenerateKeystoreComponent} from './Component/keystore/generate-keystore/generate-keystore.component';
import {CertificateSelfSignedNewComponent} from './Component/certificate/certificate-self-signed-new/certificate-self-signed-new.component';
import {CertificateAllComponent} from './Component/certificate/certificate-all/certificate-all.component';
import {CertificateRelationsComponent} from './Component/certificate/certificate-relations/certificate-relations.component';
import { AdditionalServiceComponent } from './Component/admin/additionalService/additional-service/additional-service.component';
import { AdditonalServiceEditComponent } from './Component/admin/additionalService/additonal-service-edit/additonal-service-edit.component';
import {AccommodationCategoryComponent} from './Component/admin/category/accommodation-category/accommodation-category.component';
import {AccommodationCategoryEditComponent} from './Component/admin/category/accommodation-category-edit/accommodation-category-edit.component';
import {AccommodationTypeComponent} from './Component/admin/type/accommodation-type/accommodation-type.component';
import {AccommodationTypeEditComponent} from './Component/admin/type/accommodation-type-edit/accommodation-type-edit.component';
import {AccommodationViewComponent} from './Component/admin/accommodation/accommodation-view/accommodation-view.component';
import {AddComponent} from './Component/admin/accommodation/add/add.component';
import {UsersManagementComponent} from './Component/admin/users-management/users-management.component';
import {AccommodationEditComponent} from './Component/admin/accommodation/accommodation-edit/accommodation-edit.component';
import {CommentComponent} from './Component/admin/comment/comment.component';


const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'register', component : RegisterComponent},
  {path: 'login', component: LogInComponent},
  {path: 'comments', component: CommentComponent},
  {path: 'certificate/new', component: CertificateNewComponent},
  {path: 'certificate/self-signed/new', component: CertificateSelfSignedNewComponent},
  {path: 'keystore/generate', component: GenerateKeystoreComponent},
  {path: 'certificate/all', component: CertificateAllComponent},
  {path: 'certificate/relations/:id', component: CertificateRelationsComponent},
  {path: 'additional-services', children: [ { path: '', component: AdditionalServiceComponent },
  {path: ':id/edit', component: AdditonalServiceEditComponent}]},
  {path: 'category-services', children: [ { path: '', component: AccommodationCategoryComponent },
      {path: ':id/edit', component: AccommodationCategoryEditComponent}]},
  {path: 'type-services', children: [ { path: '', component: AccommodationTypeComponent},
      {path: ':id/edit', component: AccommodationTypeEditComponent}]},
  {path: 'accommodation view', children: [ {path: '', component: AccommodationViewComponent},
      {path: ':id/edit', component: AccommodationEditComponent}]},
  {path: 'add-accommodation', component: AddComponent},
  {path: 'users-management', component: UsersManagementComponent}

];


@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(appRoutes, { useHash: true }), FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
