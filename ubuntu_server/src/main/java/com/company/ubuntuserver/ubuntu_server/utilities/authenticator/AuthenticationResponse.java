package com.company.ubuntuserver.ubuntu_server.utilities.authenticator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



public class AuthenticationResponse {


    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
