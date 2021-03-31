import { Component, OnInit } from '@angular/core';
import {findUser} from '../../models/IUserProfile';
import {FindUserService} from '../../services/find-user.service';



@Component({
  selector: 'app-find-user',
  templateUrl: './find-user.component.html',
  styleUrls: ['./find-user.component.css']
})
export class FindUserComponent implements OnInit {

  findUserForm:findUser | any = {}

  userFound 
  constructor(private findUserService:FindUserService) { }

  ngOnInit(): void {
  }

  findUser(){
    this.findUserService.findUser(this.findUserForm)
      .subscribe(res =>{
          
      }, err =>{

      })
  }

}
