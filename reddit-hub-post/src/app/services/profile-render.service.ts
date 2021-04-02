import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {allUsers, iUserProfile} from '../models/IUserProfile';

@Injectable({
  providedIn: 'root'
})
export class ProfileRenderService {

  private BASE_URL = "http://127.0.0.1:8080";

  private BASE_URL_PREFERENCES = "http://127.0.0.1:8080/preference/newPreference";
  userProfile:iUserProfile [] | any;
  findAllUsers:allUsers[] | any;

  constructor(private http:HttpClient) { }


  renderProfile(){
    return this.http.get<any>(this.BASE_URL+`/user/profile/${localStorage.getItem("email")}`);
  }

  createNewPreference(preference:any, userId:number){
    return this.http.post<any>(this.BASE_URL_PREFERENCES+`/${userId}`, preference);
  }


  makePost(postForm:any, userId:number){
    return this.http.post<any>(this.BASE_URL+`/post/newPost/${userId}`, postForm)
  }





}
