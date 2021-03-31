import { Component, OnInit } from '@angular/core';
import {ProfileRenderService} from '../../services/profile-render.service';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(public profile:ProfileRenderService) { }

     


  ngOnInit(): void {
    this.getUserProfile();
  }

  getUserProfile(){
    this.profile.renderProfile()
    .subscribe(
      res => this.profile.userProfile = res,
      err => {
        console.log(err);
        
      }
    );
  }

}
