import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AgmCoreModule} from '@agm/core';
import { AppComponent } from './app.component';
import { RegisterComponent } from './Component/users/register/register.component';
import { AppRoutingModule } from './app-routing.module';
import {ToastrModule} from 'ng6-toastr-notifications';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HomeComponent } from './Component/home/home.component';
import { NavbarComponent } from './Component/navbar/navbar.component';
import { LogInComponent } from './Component/users/log-in/log-in.component';
import { CertificateNewComponent } from './Component/certificate/certificate-new/certificate-new.component';
import { GenerateKeystoreComponent } from './Component/keystore/generate-keystore/generate-keystore.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { CertificateSelfSignedNewComponent } from './Component/certificate/certificate-self-signed-new/certificate-self-signed-new.component';
import { CertificateAllComponent } from './Component/certificate/certificate-all/certificate-all.component';
import { CertificateRelationsComponent } from './Component/certificate/certificate-relations/certificate-relations.component';
import {TokenInterceptorService} from './Service/security/token-interceptor';
import {CanActivateService} from './Service/security/can-activate.service';
import { AdditionalServiceComponent } from './Component/admin/additionalService/additional-service/additional-service.component';
import { AdditonalServiceEditComponent } from './Component/admin/additionalService/additonal-service-edit/additonal-service-edit.component';
import { AccommodationCategoryComponent } from './Component/admin/category/accommodation-category/accommodation-category.component';
import { AccommodationCategoryEditComponent } from './Component/admin/category/accommodation-category-edit/accommodation-category-edit.component';
import { AccommodationTypeComponent } from './Component/admin/type/accommodation-type/accommodation-type.component';
import { AccommodationTypeEditComponent } from './Component/admin/type/accommodation-type-edit/accommodation-type-edit.component';
import { AccommodationViewComponent } from './Component/admin/accommodation/accommodation-view/accommodation-view.component';
import { AddComponent } from './Component/admin/accommodation/add/add.component';
import { UsersManagementComponent } from './Component/admin/users-management/users-management.component';
import { AccommodationEditComponent } from './Component/admin/accommodation/accommodation-edit/accommodation-edit.component';
import { CommentComponent } from './Component/admin/comment/comment.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    NavbarComponent,
    LogInComponent,
    CertificateNewComponent,
    GenerateKeystoreComponent,
    CertificateSelfSignedNewComponent,
    CertificateAllComponent,
    CertificateRelationsComponent,
    AdditionalServiceComponent,
    AdditonalServiceEditComponent,
    AccommodationCategoryComponent,
    AccommodationCategoryEditComponent,
    AccommodationTypeComponent,
    AccommodationTypeEditComponent,
    AccommodationViewComponent,
    AddComponent,
    UsersManagementComponent,
    AccommodationEditComponent,
    CommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyASZnJHUH1aCQ8554bI4YKtxiFpmEpnAKo',
      libraries: ['places']
    }),
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    CanActivateService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
