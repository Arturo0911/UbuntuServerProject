package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserStructure {

    /**
     *
     * TODO:
     *      - Format users to show much more pretty all the users features
     */

    public HashMap formatUser(User user){

        HashMap<Object, Object> userManagement = new HashMap<>();
        userManagement.put("userId", user.getUserId());
        userManagement.put("userName", user.getUserName());
        userManagement.put("userLastName", user.getUserLastName());
        userManagement.put("userBirth", user.getUserBirth());
        userManagement.put("userPhoneNumber", user.getPhoneNumber());
        return userManagement;
    }

    public List formatUsers(List<User> users){

        List<HashMap<Object, Object>> allUsersManagement = new ArrayList<>();
        for(User user: users){
            allUsersManagement.add(formatUser(user));
        }
        return allUsersManagement;
    }
}
