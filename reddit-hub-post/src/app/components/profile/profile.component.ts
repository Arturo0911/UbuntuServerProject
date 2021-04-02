import { Component, OnInit } from '@angular/core';
import { ProfileRenderService } from '../../services/profile-render.service';
import { FindUserService } from '../../services/find-user.service';
import { findUser, makePost } from 'src/app/models/IUserProfile';
import { Router } from '@angular/router';
import { PostServiceService } from '../../services/post-service.service';
import { NgForm } from '@angular/forms';


/**
 * @author Arturo Negreiros 
 */

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  findUserForm: findUser|any = {};
  makeAPost: makePost|any = {};
  

  constructor(public profile: ProfileRenderService,
    public userToFind: FindUserService,
    private router: Router,
    public postService: PostServiceService) { }

  ngOnInit(): void {
    this.getUserProfile();
  }

  getUserProfile(): void {
    this.profile.renderProfile()
      .subscribe(
        res => {
          this.profile.userProfile = [res.response]
          localStorage.setItem("userId",res.response.userId);
          
        },
        err => {
          console.log(err);

        }
      );
  }

  onPostButton(form:NgForm) {
    //this.router.navigate(['/profile']);
    console.log(form.value);
    
    this.profile.makePost(this.makeAPost, Number(localStorage.getItem("userId")))
      .subscribe(
        res=>  {
          this.getUserProfile();
          this.router.navigate(['profile']);
          form.reset();
        },
        err => console.log(err)

      )
      
  }  
  goToFindUserPage(){
    this.router.navigate(['/found']);
  }

}
