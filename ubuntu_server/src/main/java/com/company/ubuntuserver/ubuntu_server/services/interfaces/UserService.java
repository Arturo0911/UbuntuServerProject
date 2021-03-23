package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    Optional<User> findUserById(Integer userId) throws UserNotInDataBaseException;
    void deleteUser(Integer userId);
    User updateUser(User user);

    List<User> findAllFollowings(Integer userId);
    void deleteFollowing(Integer userId, Integer user);
    void followUser(Integer userFollower, Integer userToFollow);
}
