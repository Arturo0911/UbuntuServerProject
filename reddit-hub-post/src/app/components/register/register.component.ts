import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {iUser} from './IUser';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})






export class RegisterComponent implements OnInit {
  

  user:iUser|any = {}

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  formatDate(date:Date):string{
    const day = date.getDate();
    const month = date.getMonth()+1;
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  }

  signUp() {
    let datePipe = new DatePipe("en-US");
    this.user.userBirth = datePipe.transform(this.user.userBirth, "dd/MM/yyyy");
    this.user.status = "Active";
    this.authService.signUp(this.user)
      .subscribe(
        res => {
          console.log(res);

        },
        err => {
          console.log(err);

        }
      );
  }

}
