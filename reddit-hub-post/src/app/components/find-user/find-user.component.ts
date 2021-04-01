import { Component, OnInit } from '@angular/core';
import { findUser } from 'src/app/models/IUserProfile';
import {FindUserService} from '../../services/find-user.service';



@Component({
  selector: 'app-find-user',
  templateUrl: './find-user.component.html',
  styleUrls: ['./find-user.component.css']
})
export class FindUserComponent implements OnInit {

  findUserForm: findUser | any = {}
  

  constructor(public userToFind:FindUserService) { }

  ngOnInit(): void {
    this.onFindUserButton();
  }

  onFindUserButton() {
    this.userToFind.findUser(this.findUserForm)
      .subscribe(res => {
        this.userToFind.userFound = [res.response];
      }, err => {
        console.log(err);
        
      })
  }


  checkUserFound() :Boolean{
    if (this.userToFind.userFound.userId  != null){
        return true;
    }else{
        return false;
    }
  }

}
