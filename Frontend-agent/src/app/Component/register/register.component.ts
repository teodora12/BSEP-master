import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../../Service/user.service';
import {Router} from '@angular/router';
import {ToastrManager} from 'ng6-toastr-notifications';
import {FormControl} from '@angular/forms';
import {MapsAPILoader} from '@agm/core';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: any;
  confirmPassword: any;
  public latitude: number;
  public longitude: number;
  validForService: boolean;
  isConfirmed: boolean;

  public searchControl: FormControl;

  public zoom: number;

  @ViewChild('search', {static: false})
  public searchElementRef: ElementRef;

  constructor(private userService: UserService, private router: Router, private mapsAPILoader: MapsAPILoader,
              private ngZone: NgZone, public toastr: ToastrManager) { }

  ngOnInit() {
    this.user = {email: '', password: '', name: '', surname: '', addressDTO:
        {country: '', city: '', street: '', streetNumber: '', longitude: '', latitude: '' }};
    this.validForService = false;
    this.isConfirmed = false;

    // set google maps defaults
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

          for (const comp of place.address_components) {
            for (const type of comp.types) {      // jer moze da ima vise tipova, npr [locality, political]
              if (type === 'country') {
                this.user.addressDTO.country = comp.long_name;
              } else if (type === 'locality' || type === 'administrative_area_level_3') {
                this.user.addressDTO.city = comp.long_name;
              } else if (type === 'route') {
                this.user.addressDTO.street = comp.long_name;
              } else if (type === 'street_number') {
                this.user.addressDTO.streetNumber = comp.long_name;
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


  private setCurrentPosition() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 12;
      });
    }
  }

register(): void {

    if (this.user.password === this.confirmPassword)
    {
      this.isConfirmed = true;
    } else {
      this.isConfirmed = false;
      this.toastr.errorToastr('Passwords must me equal!', 'Error');

    }


    this.user.addressDTO.latitude = this.latitude;
    this.user.addressDTO.longitude = this.longitude;
    console.log(this.user);

    if (this.user.email === '' || this.user.password === '' || this.user.name === ''
      || this.user.surname === '' || this.user.addressDTO.country === '' || this.user.addressDTO.city === ''
      || this.user.addressDTO.street === '' || this.user.addressDTO.streetNumber === '') {
      this.toastr.errorToastr('You must type all data!', 'Error');
      this.validForService = false;
    } else {
      this.validForService = true;
    }

    if (this.validForService === true && this.isConfirmed === true) {
      this.userService.register(this.user).subscribe(newUser => {
        this.user = newUser;
        this.toastr.successToastr('You are registered', 'Success');
        this.router.navigate(['/home'], {});
      }, error1 => {
        this.toastr.errorToastr('WRONG FORMAT OR ACCOUNT EXSISTS FOR THIS EMAIL!', 'Error');

      });
    }
  }
}
