package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.services.interfaces.LoginService;
import com.company.ubuntuserver.ubuntu_server.utilities.authenticator.AuthenticationRequest;
import com.company.ubuntuserver.ubuntu_server.utilities.authenticator.AuthenticationResponse;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/authenticate")
    ResponseEntity<JsonResponseBody> authentication(@RequestBody AuthenticationRequest auth){

        try {
            loginService.authentication(auth.getEmail(), auth.getPassword());
            String jwt = loginService.createJWT(auth.getEmail());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, new AuthenticationResponse(jwt)
                            ));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).
                    body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),
                            ServerMessages.errorMessage, e.toString() ));
        }
    }
}
