package com.company.ubuntuserver.ubuntu_server.services;


import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.UserService;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    IUser iUser;

    @Override
    public List<User> getAllUsers() {
        return iUser.findAll();
    }

    @Override
    public Optional<User> findUserById(@NotNull Integer userId) throws UserNotInDataBaseException {

        Optional<User> findUser = iUser.findById(userId);
        if (findUser.isPresent()){
            User user = findUser.get();
            if (user == null){
                throw new UserNotInDataBaseException("User not found in database");
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteUser(@NotNull Integer userId) {
        Optional<User>user = iUser.findById(userId);
        user.get().setStatus("INACTIVE");
        iUser.save(user.get());

    }

    @Override
    public User updateUser(@NotNull User user) {
        try {
            return iUser.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<User> findAllFollowings(Integer userId) {
        try {
            Optional<User> followers = iUser.findById(userId);
            return followers.get().getUsers();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteFollowing(Integer userId, Integer user) {
        // Unfollow method
        Optional<User> userFollow = iUser.findById(userId);
        Optional<User> userToUnFollow = iUser.findById(user);

        userFollow.get().getUsers().remove(userToUnFollow.get());
    }

    @Override
    public void followUser(Integer userFollower, Integer userToFollow) {
        Optional<User> userFollow = iUser.findById(userFollower);
        Optional<User> newUser = iUser.findById(userToFollow);
        userFollow.get().getUsers().add(newUser.get());
        iUser.save(userFollow.get());
    }
}
