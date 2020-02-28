import { Component, OnInit } from '@angular/core';
import {AccommodationService} from '../../Service/accommodation.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {UserService} from '../../Service/user.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  accommodations: any;
  accommodation: any;
  agentUsername: string;
  userRole: any;


  constructor(private accommodationService: AccommodationService, private router: Router, private toastr: ToastrManager,
              private userService: UserService) {
    this.accommodation = { name: '', address: '', description: '', accommodationCategory: '', cancellation: '',
      rate: '', agent: '', comments: [], pricelist: '', capacity: '', numberOfPeopleCapacity: '', picture: [],
      room: []};
  }



  ngOnInit() {


    this.userRole = this.userService.getLoggedUserType();
    const userTemp = JSON.parse(localStorage.getItem('loggedUser'));

    if (userTemp !== null) { this.getAccommodationsByUsername(userTemp.sub); }

  }

  getAccommodations(): void {
    this.accommodationService.getAccommodations().subscribe( accommodations => {
      this.accommodations = accommodations;

    });
  }

  getAccommodationsByUsername(username: string): void {
    this.accommodationService.getAccommodationsByAgent(username).subscribe(accommodations => {
      console.log(accommodations);
      this.accommodations = accommodations;

      if (this.accommodations.length === 0 || this.accommodations === null ) {
        this.toastr.warningToastr('You have no accommodations!', 'Warning');

      } else {

        this.accommodations = accommodations;
        for (let i = 0; i < this.accommodations.length; i++) {
                this.accommodationService.getCommentsForAcc(this.accommodations[0].id).subscribe(comments => {
                  this.accommodations[i].comments = comments;
                  console.log(this.accommodations[i].comments = comments);

                });

                this.accommodationService.getRateForAcc(this.accommodations[0].id).subscribe(rate => {
                  const res = rate['sum'] / rate['count'];
                  this.accommodations[i].rate = res;

          });

        }

      }
    });
  }

  accommodationProfile(accommodation: any): void {

    console.log(accommodation.id);
    this.router.navigate(['/accommodation/'.concat(accommodation.id)]);
  }

}
