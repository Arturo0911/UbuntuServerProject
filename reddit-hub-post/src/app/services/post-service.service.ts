import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  constructor(private http:HttpClient) { }

  private POST_URL = "";


  makePost(postBody:any){
    return this.http.post<any>(this.POST_URL, postBody);
  }



}
