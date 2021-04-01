import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { FollowingsComponent } from './components/followings/followings.component';
import { AboutComponent } from './components/about/about.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {AuthGuard} from './auth.guard';
import { ProfileComponent } from './components/profile/profile.component';
import {TokenInterceptorService} from './services/token-interceptor.service';
import { FindUserComponent } from './components/find-user/find-user.component';
import { HomeComponent } from './components/home/home.component';
import { PostRegisterComponent } from './components/post-register/post-register.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    FollowingsComponent,
    AboutComponent,
    ProfileComponent,
    FindUserComponent,
    HomeComponent,
    PostRegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthGuard,{
      provide:HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
