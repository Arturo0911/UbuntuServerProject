import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {iUserProfile} from '../models/IUserProfile';

@Injectable({
  providedIn: 'root'
})
export class ProfileRenderService {

  private BASE_URL = "http://127.0.0.1:8080";
  
  userProfile:iUserProfile [] | any;
  constructor(private http:HttpClient) { }


  renderProfile(){
    return this.http.get<any>(this.BASE_URL+`/user/profile/${localStorage.getItem("email")}`);
  }





}
