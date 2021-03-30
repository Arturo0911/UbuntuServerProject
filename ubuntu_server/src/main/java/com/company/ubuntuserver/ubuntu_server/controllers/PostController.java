package com.company.ubuntuserver.ubuntu_server.controllers;


import com.company.ubuntuserver.ubuntu_server.entities.Post;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.PostService;
import com.company.ubuntuserver.ubuntu_server.utilities.JsonResponseBody;
import com.company.ubuntuserver.ubuntu_server.utilities.messages.ServerMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/allPosts/{userId}")
    public ResponseEntity<JsonResponseBody> allPosts(@PathVariable("userId") Integer userId){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, postService.getAllPost(userId)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Error trying to get posts"));
        }
    }

    @PostMapping("/newPost/{userId}")
    public ResponseEntity<JsonResponseBody> newPost(@RequestBody Post post, @PathVariable("userId") Integer userId){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, postService.newPost(post,userId)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Error trying to save new post"));
        }
    }

    @PutMapping("/updatePost/{userId}")
    public ResponseEntity<JsonResponseBody> updatePost(@PathVariable("userId") Integer userId,@RequestBody Post post){
        try {
            postService.updatePost(userId,post);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, "Updated successfully"));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Error trying to update post"));
        }
    }


    @PostMapping("/deletePost/{userId}")
    public ResponseEntity<JsonResponseBody> deletePost(@PathVariable("userId") Integer userId,@RequestBody Post post){
        try {
            postService.deletePost(userId,post);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, "Post was deleted successfully"));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Error trying to delete new post"));
        }
    }

    @PostMapping("/likePost/{postId}/{userId}")
    public ResponseEntity<JsonResponseBody> likePost(@PathVariable("postId") Integer postId,@PathVariable("postId") Integer userId){
        try {
            postService.likeToPost(postId, userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, "Like it!"));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Not Like"));
        }
    }

    @PostMapping("/filterByDate/{datePost}")
    public ResponseEntity<JsonResponseBody> filterByDate(@RequestBody User user, @PathVariable("datePost") Date datePost){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new JsonResponseBody(HttpStatus.OK.value(),
                            ServerMessages.successMessage, postService.findPostUnderDate(user, datePost)));
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(),
                            ServerMessages.successMessage, "Error trying to get posts"));
        }
    }




}
