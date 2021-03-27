package com.company.ubuntuserver.ubuntu_server.utilities.authenticator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class AuthenticationResponse {

    @Getter @Setter
    private String jwt;

}
