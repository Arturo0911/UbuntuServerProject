import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProfileRenderService {

  private BASE_URL = "http://127.0.0.1:8080";

  constructor(private http:HttpClient) { }


  renderProfile(){
    return this.http.get<any>(this.BASE_URL+`/user/profile/${localStorage.getItem("email")}`);
  }





}
