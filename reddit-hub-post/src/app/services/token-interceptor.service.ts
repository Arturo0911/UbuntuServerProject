import { Injectable } from '@angular/core';
import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {AuthService} from './auth.service'; 


@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private authService:AuthService){}

  intercept(req:HttpRequest<any>, next:HttpHandler){
    let tokenizeRequest = req.clone({
      setHeaders:{
        'Content-Type' : 'application/json; charset=utf-8',
        'Accept'       : 'application/json',
        'Authorization': `Bearer ${this.authService.getToken()}`
      }
    });

    return next.handle(tokenizeRequest);
  }

  
}
