import {Injectable, Injector} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserService} from '../user.service';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private inj: Injector) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const accountService: UserService = this.inj.get(UserService);
    req = req.clone({
      // url: req.url.replace('http://localhost:4201', 'https://localhost:8762/'),
  //    url: 'https://localhost:8762/' + req.url,
      setHeaders: {
        Authorization : `${accountService.getToken()}`
      }
    });
    return next.handle(req);
  }
}
