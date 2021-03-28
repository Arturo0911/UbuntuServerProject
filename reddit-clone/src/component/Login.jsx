import React,{useEffect, useState} from 'react';
import Axios from 'axios';



import reddit from '../assets/static/reddit.png';
import '../assets/styles/component/Login.css';

const Login = () => (
  <div id = "Form_login">
    <form action="/auth/login" method="POST">
    <input type="text" placeholder="usuario" name="user" />
    <input type="password" placeholder="password" name="password" />
    <button className="btn btn-success" id="Login_button" type="submit"> Log in</button>
    <a href="/auth/signup" id="Register_button" class="btn btn-primary">Register now</a>
  </form>
  </div>
  
);


export default Login;