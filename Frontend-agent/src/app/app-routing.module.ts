import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './Component/home-page/home-page.component';
import {FormsModule} from '@angular/forms';
import {RegisterComponent} from './Component/register/register.component';
import {LoginComponent} from './Component/login/login.component';
import {AllMessagesComponent} from './Component/all-messages/all-messages.component';
import {CreateMessageComponent} from './Component/create-message/create-message.component';
import {AllReservationsComponent} from './Component/all-reservations/all-reservations.component';
import {AccommodationProfileComponent} from './Component/home-page/accommodation-profile/accommodation-profile.component';
import {AccommodationRoomsComponent} from './Component/home-page/accommodation-profile/accommodation-rooms/accommodation-rooms.component';
import {RoomNewComponent} from './Component/home-page/accommodation-profile/accommodation-rooms/room-new/room-new.component';
import {RoomUpdateComponent} from './Component/home-page/accommodation-profile/accommodation-rooms/room-update/room-update.component';
import {RoomReservationComponent} from './Component/home-page/accommodation-profile/accommodation-rooms/room-reservation/room-reservation.component';



const appRoutes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomePageComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'messages', component: AllMessagesComponent},
  {path: 'message/create/:id', component: CreateMessageComponent},
  {path: 'reservations', component: AllReservationsComponent},

  {path: 'accommodation/:id', component: AccommodationProfileComponent,
    children: [
      {path: 'rooms', component: AccommodationRoomsComponent}
    ]

  },
  {path: 'accommodation/room/new/:accName', component: RoomNewComponent},
  {path: 'accommodation/room/update/:roomNumber/:roomId', component: RoomUpdateComponent},
  {path: 'accommodation/reservation/:roomId', component: RoomReservationComponent}

];


@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(appRoutes), FormsModule
  ],
  exports: [RouterModule]
})


export class AppRoutingModule { }
