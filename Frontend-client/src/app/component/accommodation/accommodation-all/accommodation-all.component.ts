import {Component, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {MessageService} from '../../../service/message.service';
import {Subscription} from 'rxjs';
import {AccommodationService} from '../../../service/accommodation.service';

@Component({
  selector: 'app-accommodation-all',
  templateUrl: './accommodation-all.component.html',
  styleUrls: ['./accommodation-all.component.css']
})
export class AccommodationAllComponent implements OnInit, OnDestroy {

  accommodations: [{price: number, rate: number, distance: number, accommodationCategory: {name: string},
    pricelist: {item: [{price: number}]}, id: number}];
  subscription: Subscription;
  filterCriteria: any;

  constructor(private router: Router, private toastr: ToastrManager, private messageService: MessageService,
              private accommodationService: AccommodationService) {
    // this.accommodations = [{price: 0, distance: 0, rating: 0, accommodationCategory: {name: ''}}];
    this.filterCriteria = 0;
  }

  ngOnInit() {
    // this.accommodations = JSON.parse(localStorage.getItem('searchResult'));
    this.subscription = this.messageService.getMessage().subscribe(message => {
      this.accommodations = message;

      for (let i = 0; i < this.accommodations.length; i++) {
        this.accommodationService.getRateForAccommodation(this.accommodations[i].id).subscribe(rate => {
          const res = rate['sum'] / rate['count'];
          this.accommodations[i].rate = res;

        });
      }
    });
  }

  sortAccommodations() {
    // let a;
    // let b;
    if (this.filterCriteria === 1) {
      this.accommodations.sort((a, b) => {
        if (a.pricelist.item[0].price < b.pricelist.item[0].price) {
          return -1;
        } else if (a.pricelist.item[0].price > b.pricelist.item[0].price) {
          return 1;
        } else {
          return 0;
        }
      });
    } else if (this.filterCriteria === 2) {
      this.accommodations.sort((a, b) => {
        if (a.accommodationCategory.name < b.accommodationCategory.name) {
          return -1;
        } else if (a.accommodationCategory.name > b.accommodationCategory.name) {
          return 1;
        } else {
          return 0;
        }
      });
    } else if (this.filterCriteria === 3) {
      this.accommodations.sort((a, b) => {
        if (a.rate < b.rate) {
          return -1;
        } else if (a.rate > b.rate) {
          return 1;
        } else {
          return 0;
        }
      });
    } else if (this.filterCriteria === 4) {
      this.accommodations.sort((a, b) => {
        if (a.distance < b.distance) {
          return -1;
        } else if (a.distance > b.distance) {
          return 1;
        } else {
          return 0;
        }
      });
    }
  }

  ngOnDestroy(): void {
    // this.messageService.clearMessage();

    // this.subscription.unsubscribe();

  }

}
