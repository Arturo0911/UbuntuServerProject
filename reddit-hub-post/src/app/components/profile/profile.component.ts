import { Component, OnInit } from '@angular/core';
import { ProfileRenderService } from '../../services/profile-render.service';
import { FindUserService } from '../../services/find-user.service';
import { findUser, makePost } from 'src/app/models/IUserProfile';
import { Router } from '@angular/router';
import { PostServiceService } from '../../services/post-service.service';


/**
 * @author Arturo Negreiros 
 */

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(public profile: ProfileRenderService,
    public userToFind: FindUserService,
    private router: Router,
    public postService: PostServiceService) { }

  findUserForm: findUser | any = {};
  makeAPost: makePost | any = {};

  ngOnInit(): void {
    this.getUserProfile();
  }

  getUserProfile(): void {
    this.profile.renderProfile()
      .subscribe(
        res => {
          this.profile.userProfile = [res.response]
        },
        err => {
          console.log(err);

        }
      );
  }

  onPostButton() {

  }

  

  findAllUsers(): void {
    this.userToFind.findAllUsers()
      .subscribe(res => {
        console.log(res.response);

        this.profile.findAllUsers = res.response;
      }, err => {
        console.log(err);

      })
  }

  checkUserFound(): Boolean {
    if (this.userToFind.userFound.userId != null) {
      return true;
    } else {
      return false;
    }
  }



}
