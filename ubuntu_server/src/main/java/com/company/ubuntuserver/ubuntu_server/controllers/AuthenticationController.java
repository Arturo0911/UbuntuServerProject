package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.config.UserService;
import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.utilities.JWTUtil;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.authenticator.AuthenticationRequest;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.LoginStructure;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.PostStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUser iUser;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private LoginStructure loginStructure;



    @PostMapping("/login")
    public ResponseEntity<JsonResponseBody> login(@RequestBody AuthenticationRequest user){

        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            authenticationManager.authenticate(auth);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            String jwt = jwtUtil.generateToken(user.getEmail());
            User logged = iUser.findUserByEmail(user.getEmail());
            loginStructure.setJwt(jwt);
            loginStructure.setEmail(user.getEmail());

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(), ServerMessages.successMessage, loginStructure));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), ServerMessages.errorMessage, "Error by: "+e.toString()));
        }

    }
}
