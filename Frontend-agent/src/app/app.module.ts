import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AgmCoreModule} from '@agm/core';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Component/navbar/navbar.component';
import { HomePageComponent } from './Component/home-page/home-page.component';
import { AppRoutingModule } from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './Component/login/login.component';
import {ToastrModule} from 'ng6-toastr-notifications';
import { RegisterComponent } from './Component/register/register.component';
import { AllMessagesComponent } from './Component/all-messages/all-messages.component';
import { CreateMessageComponent } from './Component/create-message/create-message.component';
import { AccommodationProfileComponent } from './Component/home-page/accommodation-profile/accommodation-profile.component';
import { AccommodationRoomsComponent } from './Component/home-page/accommodation-profile/accommodation-rooms/accommodation-rooms.component';
import { RoomNewComponent } from './Component/home-page/accommodation-profile/accommodation-rooms/room-new/room-new.component';
import { RoomUpdateComponent } from './Component/home-page/accommodation-profile/accommodation-rooms/room-update/room-update.component';
import { AllReservationsComponent } from './Component/all-reservations/all-reservations.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { RoomReservationComponent } from './Component/home-page/accommodation-profile/accommodation-rooms/room-reservation/room-reservation.component';
import {CanActivateService} from './Service/security/can-activate.service';
import {TokenInterceptorService} from './Service/security/token-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomePageComponent,
    LoginComponent,
    RegisterComponent,
    AllMessagesComponent,
    CreateMessageComponent,
    AllReservationsComponent,
    CreateMessageComponent,
    AccommodationProfileComponent,
    AccommodationRoomsComponent,
    RoomNewComponent,
    RoomUpdateComponent,
    RoomReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyASZnJHUH1aCQ8554bI4YKtxiFpmEpnAKo',
      libraries: ['places']
    }),
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    NgbModule
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
