import React from 'react';
import {BrowserRouter, Route} from 'react-router-dom';


import Home from '../component/Home';
import Login from '../component/Login';
import Register from '../component/Register';

const Router = () => (
    <BrowserRouter>
        <Route exact path="/" component={Home} ></Route>
        <Route exact path="/login" component={Login} ></Route>
        <Route exact path= "/register" component={Register}></Route>
    </BrowserRouter>
);

export default Router;    