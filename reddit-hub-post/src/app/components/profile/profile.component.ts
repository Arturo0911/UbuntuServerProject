import { Component, OnInit } from '@angular/core';
import { ProfileRenderService } from '../../services/profile-render.service';
import { FindUserService } from '../../services/find-user.service';
import { findUser, iFormPreferences, makePost } from 'src/app/models/IUserProfile';
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

  preferencesForm: iFormPreferences | any = {};


  ngOnInit(): void {
    this.getUserProfile();
    //this.checkPreferences();
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

  checkPreferences():boolean{
    console.log(this.profile.userProfile);
    if(this.profile.userProfile[0].preference == null){
      
        return true;
    }else{
        return false;
        
    }
  }

  
  goToFindUserPage(){
    this.router.navigate(['/found']);
  }


  registerPreferences(){

  }



}
