import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL = 'http://127.0.0.1:8080';

  constructor(private http:HttpClient) { }

  signUp(user:any){
    return this.http.post<any>(this.URL+"/user/newUser", user);
  }


}