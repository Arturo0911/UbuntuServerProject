import { Component, OnInit } from '@angular/core';
import { iFormPreferences } from '../../models/IUserProfile';
import {ProfileRenderService} from '../../services/profile-render.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-post-register',
  templateUrl: './post-register.component.html',
  styleUrls: ['./post-register.component.css']
})
export class PostRegisterComponent implements OnInit {

  constructor(private profile:ProfileRenderService,
    private router:Router) { }

  preferencesForm: iFormPreferences|any = {};



  ngOnInit(): void {
  }



  registerPreferences():void{
    this.profile.createNewPreference(this.preferencesForm,Number(localStorage.getItem("userId")))
      .subscribe(
        res => {
          console.log(localStorage.getItem("userId"));
          console.log(res);
        }, err =>{
          console.log(err);
          
        }
      )
  }

}
