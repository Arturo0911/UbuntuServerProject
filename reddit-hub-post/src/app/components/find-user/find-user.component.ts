import { Component, OnInit } from '@angular/core';
import { findUser } from 'src/app/models/IUserProfile';
import {FindUserService} from '../../services/find-user.service';
//import {ProfileComponent} from '../profile/profile.component';


@Component({
  selector: 'app-find-user',
  templateUrl: './find-user.component.html',
  styleUrls: ['./find-user.component.css']
})
export class FindUserComponent implements OnInit {

  findUserForm: findUser | any = {};
  objectEmpty:any = {}
  userIdToFollow:number = 0; // contains the userId to be followed

  constructor(public userToFind:FindUserService) { }

  ngOnInit(): void {
    //console.log(this.userToFind.userFound);
    
  }

  onFindUserButton(): void {
    this.userToFind.findUser(this.findUserForm)
      .subscribe(res => {
        this.userToFind.userFound = [res.response];
        this.userIdToFollow = res.response.userId;
        //console.log(this.userToFind.userFound);
        
      }, err => {
        console.log(err);

      })
  }

  checkUserFound(): boolean{
    if (this.userToFind.userFound  != null){
        return true;
    }else{
        return false;
    }
  }

  follow(){
    this.userToFind.followUser(Number(localStorage.getItem("userId")),this.userIdToFollow, this.objectEmpty )
      .subscribe(
        res=>{
          console.log(res);
        }, err => {
          console.log(err);
          
        }
      )
  }

}
