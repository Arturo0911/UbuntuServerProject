import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL = 'http://127.0.0.1:8080';

  constructor(private http:HttpClient, private router:Router) { }

  signUp(user:any){
    return this.http.post<any>(this.URL+"/user/newUser", user);
  }

  signIn(userLogin:any){
    return this.http.post<any>(this.URL+"/auth/login", userLogin);
  }

  isLoggedIn():boolean{
    return !!localStorage.getItem("token");
  }

  getToken():string | null{
    return localStorage.getItem("token");
  }

  logOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("email");
    this.router.navigate(["/login"]);
  }


}
