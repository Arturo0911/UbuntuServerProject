package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.UserService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.function.Supplier;

@Log
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    ResponseEntity<JsonResponseBody> testing(){

        HashMap<Object, Object> response = new HashMap<>();
        response.put("name", "Arturo");
        response.put("age", 28);


        return ResponseEntity.status(HttpStatus.OK)
                .body(new JsonResponseBody(HttpStatus.OK.value(),
                        ServerMessages.successMessage, response));
    }


    /*@GetMapping("/allUsers")
    ResponseEntity<JsonResponseBody> allUsers(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, userService.getAllUsers()));
        } catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }*/


    @GetMapping("/allFollowers/{userId}")
    ResponseEntity<JsonResponseBody> findFollowings(@Valid @PathVariable("userId") Integer userid){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,
                            userService.findAllFollowings(userid)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }


    @DeleteMapping("/unFollow/{userToUnFollow}")
    ResponseEntity<JsonResponseBody> unFollow(@Valid Integer userId,@Valid @PathVariable("userToUnFollow") Integer userToUnFollow){
        try {
            userService.deleteFollowing(userId, userToUnFollow);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,"Un follow user"));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @PostMapping("/follow/{userFollower}/{userToFollow}")
    ResponseEntity<JsonResponseBody> follow(@Valid @PathVariable("userFollower") Integer userFollower,
                                            @Valid @PathVariable("userToFollow") Integer userToFollow){
        try {
            userService.followUser(userFollower, userToFollow);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,"ok"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }


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

    @PostMapping(value = "/newUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<JsonResponseBody> newUser( @RequestBody User user){
        try {
            //log.info((Supplier<String>) user);

            userService.newUser(user);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, user));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
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
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,"User was deleted successfully"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }



}
