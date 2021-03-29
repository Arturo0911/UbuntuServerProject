import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {iUser} from './IUser';


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
    //this.user.userBirth  =
    console.log(this.user.userBirth.getMonth());
    
    console.log(this.user);
    //this.user.userBirth = new Date();
    /*this.authService.signUp(this.user)
      .subscribe(
        res => {
          console.log(res);

        },
        err => {
          console.log(err);

        }
      );*/
  }

}
