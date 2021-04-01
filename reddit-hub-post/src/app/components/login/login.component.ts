import { Component, OnInit } from '@angular/core';
import {IUserLogin} from './IUserLogin';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  userLogin:IUserLogin|any = {}

  constructor(private router:Router,
    private authService:AuthService) { }

  ngOnInit(): void {
  }

  signIn(){
    //console.log(this.userLogin);
    
    this.authService.signIn(this.userLogin)
      .subscribe(res =>{
        //console.log(res.response.jwt)
        localStorage.setItem("token", res.response.jwt)
        localStorage.setItem("email", res.response.email)
        this.router.navigate(['profile'])
      }, 
      err => {
        console.log(err);
      })
  }

}
