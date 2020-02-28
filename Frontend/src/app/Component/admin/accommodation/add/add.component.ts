import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {CategoryService} from '../../../../Service/admin/category.service';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {AccommodationTypeService} from '../../../../Service/admin/accommodation-type.service';
import {AdditionalService} from '../../../../Service/admin/additional.service';
import {UserManagementServiceService} from '../../../../Service/admin/user-management-service.service';
import {MapsAPILoader} from '@agm/core';
import {UserService} from '../../../../Service/user.service';
import {AccommodationService} from '../../../../Service/admin/accommodation.service';
import {Router} from '@angular/router';
import {formatDate} from '@angular/common';
import {Toastr, ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  accommodation: any;
  private services = [];
  private types = [];
  private additional = [];
  agents: any;
  check: boolean;
  localId: number;
  imgName: any;
  url: any;
  urls: string;
  i = '';
  public latitude: number;
  public longitude: number;


  novaAdresa = {country: '', city: '' , street: '', streetNumber: ''};
  sacijenom: { id: null, price: null};
  id: any;
  moreThanOne: any;
  pricePlans = [];
  finalPricePlans = [];
  priceP: any;
  dodatno: any;
  showNewPricePlan: any;
  onlyAdditional = [];
  add:any;
  pictures = [];
  addPrice: boolean;
  public searchControl: FormControl;
  userRole: any;
  pricePlan: any;
  public zoom: number;
  checkedList = [];
  cancellation = false;
  adress: any;
  validation: boolean;

  apartmentForm = this.formBuilder.group({
    name: ['', Validators.required],
    description: ['', Validators.required],
    type: [, Validators.required],
    category: [, Validators.required],
    capacityy: [0, Validators.required],
    agent: [, Validators.required],
    image: [, Validators.required],
    additional: [, Validators.required],
    pricePlans: [],
    startPeriodDate: [Date, Validators.required],
    endPeriodDate: [Date, Validators.required],
    price: [, Validators.required],
    capacity: [, Validators.required],
    additionalPrice: [, Validators.required],
    days: [, Validators.required],
    country: [, Validators.required],
    city: [, Validators.required],
    street: [, Validators.required],
    streetNumber: [, Validators.required]


  });


  @ViewChild('search')
  public searchElementRef: ElementRef;

  constructor(private categoryService: CategoryService, private formBuilder: FormBuilder,
              private typeS: AccommodationTypeService, private  additionalService: AdditionalService,
              private  agentService: UserManagementServiceService,
              private mapsAPILoader: MapsAPILoader,
              private ngZone: NgZone, private userService: UserService,
              private accommodationService: AccommodationService,
              private router: Router, private toastr: ToastrManager) {


  }




  ngOnInit() {
    this.validation = false;
    this.userRole = this.userService.getLoggedUserType();

    // this.accommodation = {
    //   name: '',
    //   address: {country: '', city: '', street: '', addressNumber: ''},
    //   description: '',
    //   accommodationType: {name: ''}, accommodationCategory: {name: ''}, cancellation: { isEnabled: true, days: ''},
    //   agent: {email: ''}, capacity: '' }
    // ;
    this.categoryService.getCategories()
      .subscribe(res => this.services = res);
    this.typeS.getTypes()
      .subscribe(res => this.types = res);
    this.additionalService.getAdditionalServices()
      .subscribe(res => this.additional = res);
    this.agentService.getAcceptedAgents()
      .subscribe(res => this.agents = res);


    this.zoom = 4;
    this.latitude = 39.8282;
    this.longitude = -98.5795;

    // create search FormControl
    this.searchControl = new FormControl();

    // set current position
    this.setCurrentPosition();

    // load Places Autocomplete
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
          console.log(place);

          for (const comp of place.address_components) {
            for (const type of comp.types) {      // jer moze da ima vise tipova, npr [locality, political]
              if (type === 'country') {
                this.novaAdresa.country = comp.long_name;
              } else if (type === 'locality' || type === 'administrative_area_level_3') {
                this.novaAdresa.city = comp.long_name;
              } else if (type === 'route') {
                this.novaAdresa.street = comp.long_name;
              } else if (type === 'street_number') {
                this.novaAdresa.streetNumber = comp.long_name;
              }
            }
          }
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
  }

  addPricePlan() {

    this.pricePlan = {
      startPeriodDate: this.apartmentForm.value.startPeriodDate ,
      endPeriodDate: this.apartmentForm.value.endPeriodDate ,
      price: this.apartmentForm.value.price ,
      capacity: this.apartmentForm.value.capacity
    }

    this.pricePlans.push(this.pricePlan);

    this.finalPricePlans.push(this.pricePlan);
    console.log(this.pricePlans);
    console.log(this.finalPricePlans);
    this.showNewPricePlan = false;
    this.moreThanOne = true;
  }


  isAnswerProvided(event: any, check: any) {


    if (event.target.checked && this.checkedList.indexOf(check) === -1) {
      console.log('usao');
      this.addPrice = true;
      this.id = check;
      this.dodatno = {id: check, price: this.apartmentForm.value.additionalPrice};
      this.add = {id: check};
      console.log(this.dodatno.price);
      this.onlyAdditional.push(this.add);
      this.checkedList.push(this.dodatno);
      console.log(this.checkedList + 'jajaja');
    } else if (!event.target.checked && this.checkedList.indexOf(check) !== -1) {
      this.checkedList.splice(this.checkedList.indexOf(check), 1);


      console.log(this.checkedList);

    }


    //   if (this.checkedList.length === 0) {
    //     this.apartmentForm.controls['pricePlans'].markAsDirty();
    //   } else {
    //     !this.apartmentForm.controls['pricePlans'].markAsDirty();
    //   }
    // }
  }


  isAnswerProvidedPP(event: any, check: any) {
    console.log(event + ' ' + check);
    if (event.target.checked && this.finalPricePlans.indexOf(check) === -1) {
      console.log('usao');
      console.log(check.price);
      this.pricePlans.push(check);
      this.finalPricePlans.push(check);
      this.priceP = {
        startPeriodDate: check.startPeriodDate,
        endPeriodDate: check.endPeriodDate,
        price: check.price,
        capacity: check.capacity
      }

      console.log(this.priceP);
      console.log(this.finalPricePlans);
    } else if (!event.target.checked && this.finalPricePlans.indexOf(check) !== -1) {

      this.finalPricePlans.splice(this.finalPricePlans.indexOf(check), 1);
      console.log(this.finalPricePlans);
      console.log(this.pricePlans);
    }
  }

  clickedCheck(id) {
    this.check = true;
    this.localId = id;
  }


  onFileChanged(event) {

    const file = event.target.files[0];
    console.log('file ' + file);

    if (this.imgName !== undefined) {
      this.imgName = this.imgName + '; ' + file.name;
    } else {
      this.imgName = file.name;
    }

    this.pictures.push(this.imgName);

    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]); // read file as data url
      reader.onload = (event) => { // called once readAsDataURL is completed
        this.url = reader.result;
        if (this.urls !== undefined) {
          this.urls = this.urls + 'ovo-je-separator' + this.url;
        } else {
          this.urls = this.url;
        }
      }
      console.log(this.urls);
    }

//      this.accommodationForm.controls['image'].setValue(this.imgName ? this.imgName : '');
    console.log('imag ' + this.imgName);
  }


  private setCurrentPosition() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 12;
      });
    }
  }

  show() {
    this.showNewPricePlan = true;
  }

  addAccommodation() {


    this.accommodation = {
      name: this.apartmentForm.value.name,
      address: {country: this.novaAdresa.country, city: this.novaAdresa.city ,
        street: this.novaAdresa.street, streetNumber: this.novaAdresa.streetNumber, longitude: this.longitude, latitude: this.latitude},
      description: this.apartmentForm.value.description,
      type: {id: this.apartmentForm.value.type}, category: {id: this.apartmentForm.value.category},
      cancellation: {isEnabled: this.cancellation , days: this.apartmentForm.value.days},
      agents: [{id: this.apartmentForm.value.agent}], capacity: this.apartmentForm.value.capacityy,
      additionalServicesWithPrices: this.checkedList,
    //  additionalServices: this.checkedList,
      pictures: this.pictures,
      pricelist: {itemDTOS: this.finalPricePlans }
    };

    if(this.accommodation.name === '' || this.accommodation.description === '' || this.accommodation.address.country === '' ||
    this.accommodation.address.city === '' || this.accommodation.address.street === '' || this.accommodation.address.streetNumber === ''
    || this.accommodation.address.longitude === '' || this.accommodation.address.latitude === '' || this.accommodation.type === null ||
    this.accommodation.category === null || this.accommodation.agents === null || this.accommodation.capacity === '') {
      this.validation = false;
      this.toastr.errorToastr('You must fill all marked fields!', 'Error');
    } else {
      this.validation = true;
    }

    if (this.validation === true) {
      this.accommodationService.addAccommodation(this.accommodation)
        .subscribe(res => {
          this.toastr.successToastr('You created accommodation !', 'Success');

          this.router.navigate(['/home']);
        }, error1 => {
          this.toastr.errorToastr('Wrong format!', 'Error');

        });
    }
  }

  cancellationFun() {
    this.cancellation = true;
  }
}
