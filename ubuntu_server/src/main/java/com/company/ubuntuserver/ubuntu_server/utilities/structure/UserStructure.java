package com.company.ubuntuserver.ubuntu_server.utilities.structure;


import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.security.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    EncryptionUtils encryptionUtils;

    public HashMap formatUser(User user){

        HashMap<Object, Object> userManagement = new HashMap<>();
        userManagement.put("userId", user.getUserId());
        userManagement.put("userName", user.getUserName());
        userManagement.put("userLastName", user.getUserLastName());
        userManagement.put("userBirth", user.getUserBirth());
        userManagement.put("userPhoneNumber", user.getPhoneNumber());
        userManagement.put("userEmail", user.getEmail());
        return userManagement;
    }

    public List formatUsers(List<User> users){

        List<HashMap<Object, Object>> allUsersManagement = new ArrayList<>();
        for(User user: users){
            allUsersManagement.add(formatUser(user));
        }
        return allUsersManagement;
    }

    /**
     *
     * @param user object to get the password and hash it
     * @return new User object with the password hashed
     */
    public User hashPassword(User user){
        user.setPassword(encryptionUtils.encryptData(user.getPassword()));
        return user;
    }

    /**
     *
     * @param password password from the request
     * @param passwordHashed password hashed from the DB
     * @return return if both password after decrypt are the same.
     */
    public boolean matchPassword(String password, String passwordHashed){
        return encryptionUtils.decryptData(passwordHashed).equals(password);
    }
}
