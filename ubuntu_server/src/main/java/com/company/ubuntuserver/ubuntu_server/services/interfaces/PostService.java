package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.Post;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.PostNotInDataBaseException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PostService {

    Post newPost(Post post);
    List<Post> getAllPost(Integer userId);
    Post findOnePost(Integer postId) throws PostNotInDataBaseException;
    void deletePost(Integer userId,Post post);
    void updatePost(Integer userId, Post post);
    List<Post> findPostUnderDate(User user, Date datePost);
}
