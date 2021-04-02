import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FoundUser} from '../models/IUserProfile';


@Injectable({
  providedIn: 'root'
})
export class FindUserService {

  private BASE_URL = "http://127.0.0.1:8080/user/searchUser";
  private BASE_URL_FIND_ALL = "http://127.0.0.1:8080/user/allUsers";
  private BASE_URL_FOLLOW = "http://127.0.0.1:8080/user/follow";

  userFound:FoundUser[] | any;  
  constructor(private http:HttpClient) { }


  findUser(findUserForm:any){
    return this.http.post<any>(this.BASE_URL, findUserForm);
  }

  findAllUsers(){
    return this.http.get<any>(this.BASE_URL_FIND_ALL);
  }

  followUser(followerId:number, followingId:number, objectEmpty:any){
    return this.http.post(this.BASE_URL_FOLLOW+`/${followingId}/${followerId}`, objectEmpty);
  }
}
