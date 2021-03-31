package com.company.ubuntuserver.ubuntu_server.services;


import com.company.ubuntuserver.ubuntu_server.daos.IPost;
import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.Post;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.PostService;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.PostNotInDataBaseException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.PostStructure;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Log
@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private IUser iUser;

    @Autowired
    private IPost iPost;

    @Autowired
    private PostStructure postStructure;

    @Override
    public Post newPost(Post post, Integer userId) {

        try {
            Optional<User> user = iUser.findById(userId);
            //User userToPost = user.get();

            iPost.save(post);
            log.info(user.get().getUserName());
            user.get().getPosts().add(post);
            iUser.save(user.get());
            return post;


        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }




    }

    @Override
    public Object getAllPost(@Valid Integer userId) {
        return postStructure.formatPostStructures(iUser.findById(userId).get().getPosts());
    }

    @Override
    public Post findOnePost(@Valid Integer postId) throws PostNotInDataBaseException {

        Optional<Post> findPost = iPost.findById(postId);
        if(findPost.isPresent()){
            Post post = findPost.get();
            if (post == null){
                throw new PostNotInDataBaseException("Post not found in database");
            }
        }
        return iPost.findById(postId).get();
    }

    @Override
    public void deletePost(@Valid Integer userId,@Valid Post post) {
        Optional<User> user = iUser.findById(userId);
        user.get().getPosts().remove(post);
        iUser.save(user.get());
    }

    @Override
    public void updatePost(@Valid Integer userId,@Valid Post post) {
        Optional<User> user = iUser.findById(userId);
        iUser.save(postStructure.updatePostLocatedInArray(user.get(), post));
    }

    @Override
    public Object findPostUnderDate(@Valid User user,@Valid Date datePost) {
        return postStructure.findPostsUnderDate(user,datePost);
    }

    @Override
    public void likeToPost(Integer postId, Integer userId) {
        try {
            Optional<Post> post = iPost.findById(postId);
            Optional<User> user = iUser.findById(userId);

            if (post != null && user != null){
                post.get().getUserLikes().add(user.get());
                iPost.save(post.get());
            }
        }catch (Exception e ){
            e.printStackTrace();

        }
    }
}
