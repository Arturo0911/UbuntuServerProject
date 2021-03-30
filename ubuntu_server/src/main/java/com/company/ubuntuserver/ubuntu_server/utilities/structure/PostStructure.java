package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import com.company.ubuntuserver.ubuntu_server.entities.Post;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class PostStructure {


    /**
     *
     * @param user this one is the List<Post> from Users entity
     * @param post the object to be inserted as new Post, set new
     *             Modify date such new Date();
     */
    public User updatePostLocatedInArray(User user, Post post){
        for(Post post1: user.getPosts()){

            if (post1.getPostId().equals(post.getPostId())){
                post1.setPostContent(post.getPostContent());
                post1.setPostModify(new Date());
                break;
            }
        }

        return user;
    }

    /**
     *
     * @param user to fetch all post inside
     * @param date the parameter to be filtered, search before that date
     * @return return List<Post> under that date.
     */

    public List<Post> findPostsUnderDate(User user,Date date){
        List<Post> posts = new ArrayList<>();
        for(Post post: user.getPosts()){
            if (post.getPostDate().before(date)){
                posts.add(post);
            }
        }
        return posts;
    }

    /**
     * Manage the likes per post
     */

    public HashMap formatPostStructure(Post post){

        HashMap<Object, Object> postStructures = new HashMap<>();
        postStructures.put("Title", post.getPostTitle());
        postStructures.put("Content", post.getPostContent());
        postStructures.put("Created at", post.getPostDate());
        postStructures.put("Likes", post.getUserLikes().size());


        return postStructures;
    }


    public List formatPostStructures(List<Post>posts){
        List<HashMap<Object, Object>> postsToFormat = new ArrayList<>();
        for (Post post: posts){
            postsToFormat.add(formatPostStructure(post));
        }

        return postsToFormat;
    }
}
