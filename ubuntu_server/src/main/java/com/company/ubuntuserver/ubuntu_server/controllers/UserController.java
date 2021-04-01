package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.IUserService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.FindUserAsynchronous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

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
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, userService.newUser(user)));
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

    @PostMapping("/saveUsers")
    public ResponseEntity<JsonResponseBody> saveMultipleUsers(@RequestBody List<User> users){
        try {
            userService.saveMultipleUsers(users);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, "Data was saved successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, e.toString()));
        }
    }


    @PostMapping("/searchUser")
    public ResponseEntity<JsonResponseBody> findAsynchronous(@RequestBody FindUserAsynchronous user){
        try {
            if (userService.findUserByUserName(user.getUserName()) != null){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new JsonResponseBody(HttpStatus.OK.value(),
                                ServerMessages.successMessage,
                                userService.findUserByUserName(user.getUserName())));
            }else if (userService.findUserByUserName(user.getUserName()) != null){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new JsonResponseBody(HttpStatus.OK.value(),
                                ServerMessages.successMessage,
                                userService.findUserByUserLastName(user.getUserLastName())));
            }else{
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new JsonResponseBody(HttpStatus.OK.value(),
                                ServerMessages.successMessage, "Task not found"));
            }
            /*return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage,
                            userService.findUserByUserName(user.getUserName())));*/
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.errorMessage, "Error by: "+e.toString()));
        }
    }



}
