package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.UserService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;




    @GetMapping("/allUsers")
    ResponseEntity<JsonResponseBody> findAllUsers(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, userService.getAllUsers()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @PostMapping("/newUser")
    ResponseEntity<JsonResponseBody> newUser(@Valid @RequestBody User user){
        try {
            userService.newUser(user);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, user));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @GetMapping("/findUser/{userId}")
    ResponseEntity<JsonResponseBody> findOneUser(@Valid @PathVariable("userId") Integer userId){
        try {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, userService.findUserById(userId)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @PutMapping("/updateUser")
    ResponseEntity<JsonResponseBody>updateUser(@Valid @RequestBody User user){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, userService.updateUser(user)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity<JsonResponseBody> deleteUser(@Valid @PathVariable("userId") Integer userId){
        try {

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }



}
