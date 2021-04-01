import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {iUserSignup} from './IUser';
import {DatePipe} from '@angular/common';
import {Router} from '@angular/router';




@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})






export class RegisterComponent implements OnInit {
  

  user:iUserSignup|any = {}

  constructor(private authService: AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  signUp() {
    let datePipe = new DatePipe("en-US");
    this.user.userBirth = datePipe.transform(this.user.userBirth, "dd/MM/yyyy");
    this.user.status = "Active";
    this.authService.signUp(this.user)
      .subscribe(
        res => {
          localStorage.setItem("userId", res.response.userId);
          this.router.navigate(['/post-register'])
        },
        err => {
          console.log(err);

        }
      );
  }

}
