package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {

    Optional<Post> newPost(Post post);
    List<Post> getAllPost(Integer userId);
    Post findOnePost(Integer postId);
    void deletePost(Post post);
    void updatePost(Post post);
    List<Post> findPostUnderDate(Date datePost);
}
