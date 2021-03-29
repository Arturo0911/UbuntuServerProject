package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.UserService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import lombok.extern.java.Log;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.function.Supplier;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allFollowers/{userId}")
    public ResponseEntity<JsonResponseBody> findFollowings(@Valid @PathVariable("userId") Integer userid){
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


    @DeleteMapping("/unFollow/{userId}/{userToUnFollow}")
    public ResponseEntity<JsonResponseBody> unFollow(@Valid @PathVariable("userId") Integer userId,
                                              @Valid @PathVariable("userToUnFollow") Integer userToUnFollow){
        try {
            userService.deleteFollowing(userId, userToUnFollow);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,"Unfollow user"));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }

    @PostMapping("/follow/{userFollower}/{userToFollow}")
    public ResponseEntity<JsonResponseBody> follow(@Valid @PathVariable("userFollower") Integer userFollower,
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
    public ResponseEntity<JsonResponseBody> findAllUsers(){
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
    public ResponseEntity<JsonResponseBody> newUser( @RequestBody User user){
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
    public ResponseEntity<JsonResponseBody> findOneUser(@Valid @PathVariable("userId") Integer userId){
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

    @PutMapping( value =  "/updateUser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseBody>updateUser(@Valid @RequestBody User user){
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
    public ResponseEntity<JsonResponseBody> deleteUser(@Valid @PathVariable("userId") Integer userId){
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


    @GetMapping("/profile/{userEmail}")
    public ResponseEntity<JsonResponseBody> getProfile(@PathVariable("userEmail") String userEmail){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,
                            userService.profileFindAll(userEmail)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }



}
