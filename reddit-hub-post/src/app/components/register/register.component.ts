import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = {
    userName: "",
    userLastName: "",
    userBirth: "",
    gender: "",
    phoneNumber: "",
    status: "Active",
    email: "",
    password: ""
}

  constructor() { }

  ngOnInit(): void {
  }

  signUp(){
    console.log(this.user);
    
  }

}
