import { Component, OnInit } from '@angular/core';
import {ProfileRenderService} from '../../services/profile-render.service';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private profile:ProfileRenderService) { }

  ngOnInit(): void {
    this.profile.renderProfile()
      .subscribe(
        res =>{
          console.log(res.response);
          
        },
        err => {
          console.log(err);
          
        }
      );
  }

}
