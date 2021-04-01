import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  constructor(private http:HttpClient) { }

  private POST_URL = "http://127.0.0.1:8080/post/newPost";


  /**
   * 
   * @param postBody postBody to be shipped
   * @param userId id object from the main user
   * @returns return the httpObject after shipped
   */
  makePost(postBody:any, userId:number){
    return this.http.post<any>(this.POST_URL+`/${userId}`, postBody);
  }



}
