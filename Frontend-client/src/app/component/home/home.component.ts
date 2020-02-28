import {Component, ElementRef, NgZone, OnInit, ViewChild, ViewEncapsulation} from '@angular/core';
import {NgbDate} from '@ng-bootstrap/ng-bootstrap';
import {ToastrManager} from 'ng6-toastr-notifications';
import {Router} from '@angular/router';
import {SearchService} from '../../service/search.service';
import {DomSanitizer} from '@angular/platform-browser';
import {MessageService} from '../../service/message.service';
import {MapsAPILoader} from '@agm/core';
import {FormControl} from '@angular/forms';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {

  @ViewChild('searchElementRef', { static: false })   // true - ucitava se nakon view-a
  public searchElementRef: ElementRef;

  hoveredDate: NgbDate;
  fromDate: NgbDate;
  toDate: NgbDate;

  isFilterVisible: any;


  additionalServices: any;
  accommodationTypes: any;
  accommodationCategories: any;
  searchObject: any;
  searchResult: any;
  cancellationEnabled: boolean;
  cancellationDays: any;
  enabledUntil: Date;


  public searchControl: FormControl;

  public latitude: number;
  public longitude: number;
  public zoom: number;


  constructor(private router: Router, private toastr: ToastrManager, private searchService: SearchService,
              private sanitaizer: DomSanitizer, private messageService: MessageService,
              private mapsAPILoader: MapsAPILoader,
              private ngZone: NgZone) { }

  ngOnInit() {
    this.isFilterVisible = false;
    this.searchObject = {town: '', country: '', fromDate: Date, toDate: Date, numberOfPersons: 1, accommodationType: null,
      accommodationCategory: null,
      distance: 0, longitude: 0, latitude: 0, additionalService: [], cancellation: null};
    this.fromDate = undefined;
    this.toDate = undefined;
    this.searchService.getAdditionalServices().subscribe(add => {
      this.additionalServices = add;
    });
    this.searchService.getAccommodationCategories().subscribe(categ => {
      this.accommodationCategories = categ;
    });
    this.searchService.getAccommodationTypes().subscribe(types => {
      this.accommodationTypes = types;


      // set google maps defaults
      this.zoom = 8;
      this.latitude = 39.8282;
      this.longitude = -98.5795;

      // create search FormControl
      this.searchControl = new FormControl();

      this.mapsAPILoader.load().then(() => {
        // @ts-ignore
        const autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
          types: ['address']
        });
        autocomplete.addListener('place_changed', () => {
          this.ngZone.run(() => {
            // get the place result
            // @ts-ignore
            const place: google.maps.places.PlaceResult = autocomplete.getPlace();
            // verify result


            if (place.geometry === undefined || place.geometry === null) {
              return;
            }

            // set latitude, longitude and zoom
            this.latitude = place.geometry.location.lat();
            this.longitude = place.geometry.location.lng();
            this.zoom = 12;
          });
        });
      });
    });

    this.cancellationDays = undefined;
    this.enabledUntil = new Date();


  }


  search() {
    if (this.searchObject.town === '' || this.searchObject.country === '' || this.toDate === undefined
      || this.toDate === null || this.fromDate === undefined) {
      this.toastr.warningToastr('Mandatory fields are empty', 'Required fields are empty');
      return;
    }

    this.searchObject.latitude = this.latitude;
    this.searchObject.longitude = this.longitude;

    this.searchObject.fromDate = new Date(Date.UTC(this.fromDate.year, this.fromDate.month - 1, this.fromDate.day,
      0, 0, 0, 0));
    this.searchObject.toDate = new Date(Date.UTC(this.toDate.year, this.toDate.month - 1, this.toDate.day,
      0, 0, 0, 0));

    if (this.cancellationDays !== undefined) {
      this.searchObject.cancellation = {};
      this.searchObject.cancellation.isEnabled = this.cancellationEnabled;
      this.searchObject.cancellation.days = this.cancellationDays;
    }

    if (this.searchObject.additionalService !== null) {
      if (this.searchObject.additionalService.length === 0) {
        this.searchObject.additionalService = null;
      }
    }

    this.searchService.searchAccommodation(this.searchObject).subscribe(searchResult => {
      this.searchResult = searchResult;

      for (const acc of this.searchResult) {
        for (let i = 0; i < acc.picture.length; i++) {
          // @ts-ignore
          // first convert byte string to byte array
          const binaryString =  window.atob(acc.picture[i]);
          const len = binaryString.length;
          const bytes = new Uint8Array( len );
          for (let j = 0; j < len; j++)        {
            bytes[j] = binaryString.charCodeAt(j);
          }
          // @ts-ignore
          const STRING_CHAR = bytes.reduce((data, byte) => {
            return data + String.fromCharCode(byte);
          }, '');
          const base64 = btoa(STRING_CHAR);
          const url = this.sanitaizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64,' + base64);
          acc.picture[i] = url;
        }
      }

      // localStorage.setItem('searchResult', JSON.stringify(this.searchResult));

      const searchParams = {fromDate: this.searchObject.fromDate, toDate: this.searchObject.toDate,
        numberOfPersons: this.searchObject.numberOfPersons};
      localStorage.setItem('searchParams', JSON.stringify(searchParams));


      this.messageService.sendMessage(this.searchResult).subscribe(ret => {
        this.router.navigate(['accommodations']);
      });
      //

    }, error1 => {
      this.toastr.errorToastr('WRONG FORMAT!', 'Error');

    });

  }

  reloadPage() {
    this.router.navigateByUrl('/accommodation', {skipLocationChange: true}).then(() =>
      this.router.navigate(['home']));
  }

  additionalServicesChanged(additionalService: any) {
    let hasBeenAdded = false;
    for (let i = 0; i < this.searchObject.additionalService.length; i++) {
      if (this.searchObject.additionalService[i].id === additionalService.id) {
        this.searchObject.additionalService.splice(i, 1);
        hasBeenAdded = true;
        break;
      }
    }
    if (!hasBeenAdded) {
      this.searchObject.additionalService.push(additionalService);
    }
  }

  cancellationEnabledSelected() {
    if (this.cancellationDays === undefined || this.cancellationDays === 0) {
      this.cancellationDays = 1;
      const dateTemp = new Date(Date.UTC(this.fromDate.year, this.fromDate.month - 1, this.fromDate.day,
        0, 0, 0, 0));
      this.enabledUntil = new Date();
      this.enabledUntil.setDate(dateTemp.getDate() - this.cancellationDays);
    }
  }

  cancellationNotEnabledSelected() {
    if (this.cancellationDays === undefined || this.cancellationDays > 0) {
      this.cancellationDays = 0;
    }
  }

  cancellationNumberOfDaysChanged() {
    if (this.cancellationDays > 0) {
      this.cancellationEnabled = true;
      const dateTemp = new Date(Date.UTC(this.fromDate.year, this.fromDate.month - 1, this.fromDate.day,
        0, 0, 0, 0));
      this.enabledUntil = new Date();
      this.enabledUntil.setDate(dateTemp.getDate() - this.cancellationDays);
    } else {
      this.cancellationEnabled = false;
    }
  }

  onDateSelect($event) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = $event;
    } else if (this.fromDate && !this.toDate && $event.after(this.fromDate)) {
      this.toDate = $event;
    } else {
      this.toDate = null;
      this.fromDate = $event;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate &&
      this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || date.equals(this.toDate)
      || this.isInside(date) || this.isHovered(date);
  }

  setAdvancedVisible() {
    this.isFilterVisible = true;
  }

  setAdvancedNotVisible() {
    this.isFilterVisible = false;
  }

  // addFilter() {
  //
  //   const filter = {airline: this.airlineNameFilter, fromDuration: this.fromDurationFilter,
  //     toDuration: this.toDurationFilter, fromPrice: this.fromPriceFilter, toPrice: this.toPriceFilter, flights: this.flights};
  //
  //   // this.flightService.filterFlights(filter).subscribe( flights => {
  //   //   this.flights = flights;
  //   //   this.airlineNameFilter = '';
  //   //   this.fromDurationFilter = '';
  //   //   this.toDurationFilter = '';
  //   //   this.fromPriceFilter = '';
  //   //   this.toPriceFilter = '';
  //   // });
  //   this.isFilterVisible = false;
  // }

}
