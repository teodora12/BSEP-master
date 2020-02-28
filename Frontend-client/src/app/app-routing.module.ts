import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {AccommodationComponent} from './component/accommodation/accommodation.component';
import {AccommodationAllComponent} from './component/accommodation/accommodation-all/accommodation-all.component';
import {LoginComponent} from './component/user/login/login.component';
import {RegisterComponent} from './component/user/register/register.component';
import {UserReservationsComponent} from './component/user/user-reservations/user-reservations.component';
import {ProfileComponent} from './component/user/profile/profile.component';
import {MessagesComponent} from './component/messages/messages.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'accommodation/:id', component: AccommodationComponent},
  {path: 'accommodations', component: AccommodationAllComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'reservations', component: UserReservationsComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'messages', component: MessagesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
