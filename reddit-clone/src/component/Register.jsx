import React from 'react';
import '../assets/styles/component/Register.css';

const Register = () => (
        <div className= "container p-4">

            <div id="card_register" className="row">
                <div className="col-md-12">
                    <div className="card">
                        <div id="card_title_register" className="card-header">
                            <h5 className="card-title" >Register and be part of us</h5>
                        </div>
                    </div>
                </div>
            </div>

            <div id="form_signup">
                <form action="/auth/signup" method="POST" encType="multipart/form-data">
                    <div className="form-row">
                        <div className="form-group col-md-5">
                            <label htmlFor="inputNombre">Nombres</label>
                            <input required type="text" className="form-control" id="inputNombre" name="name" />
                        </div>
                        <div className="form-group col-md-5">
                            <label htmlFor="inputApellido">Apellidos</label>
                            <input required type="text" className="form-control" id="inputApellido" name="lname" />
                        </div>
                        <div className="form-group col-md-5">
                            <label htmlFor="inputTelefono">Email</label>
                            <input required type="text" className="form-control" id="inputEmail4" name="email" name="email" />
                        </div>
                        <div className="form-group col-md-3">
                            <label htmlFor="inputTelefono">Telefono</label>
                            <input required type="text" className="form-control" id="inputTelefono" name="phone" />
                        </div>
                    </div>
                    <div className="form-row">
                        <div className="form-group col-md-5">
                            <label htmlFor="inputApartment">Gender</label>
                            <select id="inputApartment" className="form-control" name="apartment">
                                <option value>Male</option>
                                <option>Female</option>
                                <option>Non binary</option>
                            </select>
                        </div>
                        <div className="form-group col-md-5">
                            <label htmlFor="inputTelefono">Email</label>
                            <input required type="text" className="form-control" id="inputEmail4" name="email" name="email" />
                        </div>
                        <div className="form-group col-md-5">
                            <label htmlFor="inputPass">Password</label>
                            <input required type="password" className="form-control" id="inputPass" name="password" />
                        </div>
                    </div>
                    <button type="submit" className="btn btn-success">Guardar</button>
                </form>


            </div>
        </div>
);


export default Register;