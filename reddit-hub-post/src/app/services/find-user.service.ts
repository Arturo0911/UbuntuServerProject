import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class FindUserService {

  private BASE_URL = "http://127.0.0.1:8080/user/searchUser";

  constructor(private http:HttpClient) { }


  findUser(findUserForm:any){
    return this.http.post<any>(this.BASE_URL, findUserForm);
  }
}
