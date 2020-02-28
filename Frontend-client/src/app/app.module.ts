import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {ToastrModule} from 'ng6-toastr-notifications';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { AccommodationComponent } from './component/accommodation/accommodation.component';
import { AccommodationAllComponent } from './component/accommodation/accommodation-all/accommodation-all.component';
import {MessageService} from './service/message.service';
import { LoginComponent } from './component/user/login/login.component';
import { RegisterComponent } from './component/user/register/register.component';
import {CanActivateService} from './service/security/can-activate.service';
import {TokenInterceptorService} from './service/security/token.interceptor';
import { ProfileComponent } from './component/user/profile/profile.component';
import { UserReservationsComponent } from './component/user/user-reservations/user-reservations.component';
import {AgmCoreModule} from '@agm/core';
import { MessagesComponent } from './component/messages/messages.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    AccommodationComponent,
    AccommodationAllComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    UserReservationsComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ToastrModule.forRoot(),
    NoopAnimationsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyASZnJHUH1aCQ8554bI4YKtxiFpmEpnAKo',
      libraries: ['places']
    })
  ],
  providers: [
    MessageService,

    CanActivateService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
