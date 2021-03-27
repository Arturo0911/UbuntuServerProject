package com.company.ubuntuserver.ubuntu_server.utilities.authenticator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class AuthenticationRequest {

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;


}
