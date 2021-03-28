import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// Components
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {FollowingsComponent} from './components/followings/followings.component';
import {AboutComponent } from './components/about/about.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch:'full'
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'register',
    component: RegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
