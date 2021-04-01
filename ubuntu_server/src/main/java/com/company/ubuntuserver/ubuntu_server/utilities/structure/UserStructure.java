package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserStructure {

    /**
     *
     * TODO:
     *      - Format users to show much more pretty all the users features
     */

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PostStructure postStructure;


    /**
     *
     * @param user object to be formatted
     * @apiNote this metjod is for the management of
     * @return HashMap with the user object format
     */
    public HashMap formatUser(User user){

        HashMap<Object, Object> userManagement = new HashMap<>();
        userManagement.put("userId", user.getUserId());
        userManagement.put("userName", user.getUserName());
        userManagement.put("userLastName", user.getUserLastName());
        userManagement.put("imagUrl", user.getImageUrl());
        userManagement.put("followers", user.getUsers().size());
        return userManagement;
    }

    public List formatUsers(List<User> users){

        List<HashMap<Object, Object>> allUsersManagement = new ArrayList<>();
        for(User user: users){
            allUsersManagement.add(formatUser(user));
        }
        return allUsersManagement;
    }

    public User formatProfile(User user){
        formatUsers(user.getUsers());
        return  user;
    }

    public HashMap formatFindUser(User user){
        HashMap<Object, Object> userFound = new HashMap<>();
        userFound.put("userId",user.getUserId());
        userFound.put("userName",user.getUserName());
        userFound.put("userLastName",user.getUserLastName());
        userFound.put("imagUrl", user.getImageUrl());
        userFound.put("followers",user.getUsers().size()); // i don't want to the whole descriptions of of followers, only the number of this
        userFound.put("posts",postStructure.formatPostStructures(user.getPosts()));
        userFound.put("preferences",user.getPreference());

        return userFound;
    }

}
