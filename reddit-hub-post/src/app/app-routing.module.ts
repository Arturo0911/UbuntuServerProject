import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// Components
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {AboutComponent } from './components/about/about.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AuthGuard} from './auth.guard';
import {FindUserComponent} from './components/find-user/find-user.component';
import {HomeComponent} from './components/home/home.component';
import {PostRegisterComponent} from './components/post-register/post-register.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch:'full'
  },{
    path: 'home',
    component: HomeComponent
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
  },{
    path: 'profile',
    component:ProfileComponent,
    canActivate: [AuthGuard]
  },{
    path: 'found',
    component:FindUserComponent,
    canActivate: [AuthGuard]
  },{
    path: 'post-register',
    component: PostRegisterComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
