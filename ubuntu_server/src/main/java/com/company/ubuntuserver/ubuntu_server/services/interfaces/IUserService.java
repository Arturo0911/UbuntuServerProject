package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.EmailExistsException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.NotSupportedEncodingException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;

import java.util.HashMap;
import java.util.List;

public interface IUserService {

    User newUser(User user) throws EmailExistsException;
    List<User> getAllUsers();
    HashMap<Object, Object> findUserById(Integer userId) throws UserNotInDataBaseException;
    void deleteUser(Integer userId);
    User updateUser(User oldUser);

    List<User> findAllFollowings(Integer userId);
    void deleteFollowing(Integer userId, Integer user);
    void followUser(Integer userFollower, Integer userToFollow);

    void saveMultipleUsers(List<User>users);

    // Before login service

    /*User authentication(String email, String password) throws UserNotInDataBaseException;

    String createJWT(String email) throws NotSupportedEncodingException;

    User findByEmail(String email);*/


    User profileFindAll(String email);

    User findUserByUserName(String userName);
    User findUserByUserLastName(String userLastName);




}
