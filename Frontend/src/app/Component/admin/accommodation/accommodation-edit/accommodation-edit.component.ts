import {
  Component,
  ElementRef,
  NgZone,
  OnInit,
  ViewChild
} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {CategoryService} from '../../../../Service/admin/category.service';
import {AccommodationTypeService} from '../../../../Service/admin/accommodation-type.service';
import {AdditionalService} from '../../../../Service/admin/additional.service';
import {UserManagementServiceService} from '../../../../Service/admin/user-management-service.service';
import {MapsAPILoader} from '@agm/core';
import {UserService} from '../../../../Service/user.service';
import {AccommodationService} from '../../../../Service/admin/accommodation.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';

@Component({
  selector: 'app-accommodation-edit',
  templateUrl: './accommodation-edit.component.html',
  styleUrls: ['./accommodation-edit.component.css']
})
export class AccommodationEditComponent implements OnInit {

  additional = [];
  editClicked = false;
  private services = [];
  private types = [];
  private  agents: any;
 // accommodation = {};

  pomocniId : any;
  edited : any;
   lista : any;
   dodatni: any;
   ostali: any;

   l = [];
   accommodation = {
     id: null,
    name: '',
    address: {country: '', city: '', street: '', streetNumber: '', longitude: '', latitude: ''},
    description: '',
    accommodationType: {id: null}, accommodationCategory: {id: null},
    cancellation: {isEnabled: true , days: null},
    agent: null, capacity: null,
    additionalServicesWithPrices: null,
    additionalServices: [],
    picture: null,
    pricelist: {item: [{startDatePeriod: null, endDatePeriod: null, price: null, category:  null} ]}
  };
  id: any;
  showPP = false;
  moreThanOne: any;
  pricePlans = [];
  finalPricePlans = [];
  priceP: any;
  dodatno: any;
  accomm = {}
  imgName: any;
  url: any;
  urls: string;
  i = '';
  showNewPricePlan: any;
  onlyAdditional = [];
  add:any;
  pictures = [];
  addPrice: boolean;
  public searchControl: FormControl;
  userRole: any;
  pricePlan: any;
  public zoom: number;
  jedanagent = [];
  agnt={id: ''};
  validation: boolean;


  public latitude: number;
  public longitude: number;
  checkedList = [];
  cancellation = false;
  apartmentForm = this.formBuilder.group({

    pricePlans: [''],
    startPeriodDate: [Date, Validators.required],
    endPeriodDate: [Date, Validators.required],
    price: ['', Validators.required],
    capacity: ['', Validators.required],
    startPeriodDate1: [Date, Validators.required],
    endPeriodDate1: [Date, Validators.required],
    price1: ['', Validators.required],
    capacity1: ['', Validators.required]

  });


  @ViewChild('search')
  public searchElementRef: ElementRef;
  agenti = this.formBuilder.group({
    IdAgenta: ['']});

  constructor(private categoryService: CategoryService, private formBuilder: FormBuilder,
              private typeS: AccommodationTypeService, private  additionalService: AdditionalService,
              private  agentService: UserManagementServiceService,
              private mapsAPILoader: MapsAPILoader,
              private ngZone: NgZone, private userService: UserService,
              private accommodationService: AccommodationService,
              private router: Router,
              private route: ActivatedRoute, private toastr: ToastrManager) {
    this.lista = [{id: '', price: ''}];


  }


  ngOnInit() {

    this.validation = false;
    this.data();




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
                this.accommodation.address.country = comp.long_name;
              } else if (type === 'locality' || type === 'administrative_area_level_3') {
                this.accommodation.address.city = comp.long_name;
              } else if (type === 'route') {
                this.accommodation.address.street = comp.long_name;
              } else if (type === 'street_number') {
                this.accommodation.address.streetNumber = comp.long_name;
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
  data() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.accommodationService.getAccommodation(this.id).subscribe(res => {// @ts-ignore
      // @ts-ignore
      this.accommodation = res ;

      this.lista = this.accommodation.agent;
      for (const additionalService of this.accommodation.additionalServicesWithPrices) {
        const tempAdditional = {name: additionalService.additionalServices.name, price: additionalService.price,
          id: additionalService.additionalServices.id, included: true};
        this.additional.push(tempAdditional);
      }

      this.additionalService.getAdditionalServices().subscribe(res1 => {
        let allAdditional = res1;
          for (const add of allAdditional) {
            let isAllreadyIncluded = false;
            for (const included of this.additional) {
              if (included['id'] === add.id) {
                isAllreadyIncluded = true;
                break;
              }
            }
            if (!isAllreadyIncluded) {

              // const tempAdditional = {name: additionalService.additionalServices.name, price: additionalService.price,
              //   id: additionalService.additionalServices.id, included: true};
              const temp = {name: add['name'], id: add['id'], price: 0, included: false};
              this.additional.push(temp);
            }
          }
        });


    } );
    this.categoryService.getCategories()
      .subscribe(res => this.services = res);
    this.typeS.getTypes()
      .subscribe(res => this.types = res);
    this.agentService.getAcceptedAgents()
      .subscribe(res => this.agents = res);


  }

  onCheckboxChangePP(event){
    this.showPP = !this.showPP;
  }


  deletePriceItem(id) {
    this.accommodationService.deleteItem(id) .subscribe(res => {
        this.ngOnInit();
      }
    );
  }

  show() {
    this.showNewPricePlan = true;
  }


  addPricePlan() {
    this.pricePlan = {
      startPeriodDate: this.apartmentForm.value.startPeriodDate,
      endPeriodDate: this.apartmentForm.value.endPeriodDate,
      price: this.apartmentForm.value.price,
      capacity: this.apartmentForm.value.capacity
    }

    this.pricePlans.push(this.pricePlan);
    this.finalPricePlans.push(this.pricePlan);
 //   this.accommodation.pricelist.item.push(this.pricePlan)
    console.log(this.pricePlans);
    console.log(this.finalPricePlans);
    this.showNewPricePlan = false;
    this.moreThanOne = true;
  }


  isAnswerProvidedPP(event: any, check: any) {
    console.log(event + ' ' + check);
    if (event.target.checked && this.finalPricePlans.indexOf(check) === -1) {
      console.log('usao');
      console.log(check.price);
      this.pricePlans.push(check);
      this.finalPricePlans.push(check);
   //   this.accommodation.pricelist.item.push(check)
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

  editItem(id) {
    this.editClicked = true;
    this.pomocniId = id;

  }


  isAnswerProvided(event: any, check: any) {


    if (event.target.checked && this.checkedList.indexOf(check) === -1) {
      console.log('usao');
      this.addPrice = true;
      this.id = check;
      this.dodatno = {additionalServices: {id: check}, price: this.apartmentForm.value.additionalPrice};
      this.add = {id: check};
      this.onlyAdditional.push(this.add);
      this.checkedList.push(this.dodatno);
      console.log(this.checkedList + 'jajaja');
    } else if (!event.target.checked && this.checkedList.indexOf(check) !== -1) {
      this.checkedList.splice(this.checkedList.indexOf(check), 1);


      console.log(this.checkedList);

    }


    if (this.checkedList.length === 0) {
      this.apartmentForm.controls['pricePlans'].markAsDirty();
    } else {
      this.apartmentForm.controls['pricePlans'].markAsDirty();
    }
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


  editAccommodation() {



    for (const nesti of this.additional){
      if (nesti['included']) {
        this.lista={id: nesti.id, price: nesti.price};
        this.l.push(this.lista);
      }
    }
    this.accomm = {
      id: this.accommodation.id,
      name: this.accommodation.name,
      address: this.accommodation.address,
      description: this.accommodation.description,
      type: this.accommodation.accommodationType, category:  this.accommodation.accommodationCategory,
      cancellation: this.accommodation.cancellation,
      agents: [{id: this.agenti.value.IdAgenta}], capacity: this.accommodation.capacity,
      additionalServicesWithPrices: this.l,
      additionalServices: [],
      pictures: this.accommodation.picture,
      pricelist: {itemDTOS:  this.finalPricePlans}
    };

    if (this.accommodation.name === '' || this.accommodation.description === '' ||
      this.accommodation.address.country === '' ||
      this.accommodation.address.city === '' || this.accommodation.address.street === '' ||
      this.accommodation.address.streetNumber === '' ||
      this.accommodation.address.longitude === '' || this.accommodation.address.latitude === '' ||
      this.accommodation.accommodationType === null ||
      this.accommodation.accommodationCategory === null || this.accommodation.agent === null ||
      this.accommodation.capacity === '') {
      this.validation = false;
      this.toastr.errorToastr('You must fill all marked fields!', 'Error');
    } else {
      this.validation = true;
    }

    if(this.validation === true) {
    this.accommodationService.editAccommodation(this.accomm)
      .subscribe(res => {
        this.toastr.successToastr('You updated accommodation !', 'Success');

        this.router.navigate(['/home']);
      }, error1 => {
        this.toastr.errorToastr('Wrong format!', 'Error');

      });
    }

  }

  aaa(id) {

    // for (let i = 0; i < this.accommodation.additionalServicesWithPrices.length; i++) {
    //   if (id === this.accommodation.additionalServicesWithPrices[i].id) {
    //     return true;
    //   }
    // }
  }


  edit() {

    this.edited = {id: this.pomocniId, startDatePeriod: this.apartmentForm.value.startPeriodDate1, endDatePeriod: this.apartmentForm.value.endPeriodDate1,
    price: this.apartmentForm.value.price1, capacity: this.apartmentForm.value.capacity1}
    console.log(this.edited);

    this.accommodationService.editItem(this.edited).subscribe(res => {
        this.ngOnInit();
      }
    );
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

}
