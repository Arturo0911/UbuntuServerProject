package com.company.ubuntuserver.ubuntu_server.services;


import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.UserService;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.UserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    IUser iUser;

    @Autowired
    UserStructure userStructure;

    @Override
    public User newUser(User user) {
        return  iUser.save(user);
    }

    @Override
    public List getAllUsers() {
        return userStructure.formatUsers(iUser.findAll());
    }

    @Override
    public HashMap<Object, Object> findUserById(@NotNull Integer userId) throws UserNotInDataBaseException {

        Optional<User> findUser = iUser.findById(userId);
        if (findUser.isPresent()){
            User user = findUser.get();
            if (user == null){
                throw new UserNotInDataBaseException("User not found in database");
            }
        }
        return userStructure.formatUser(findUser.get());
    }

    @Override
    public void deleteUser(@NotNull Integer userId) {
        Optional<User>user = iUser.findById(userId);
        user.get().setStatus("INACTIVE");
        iUser.save(user.get());

    }

    @Override
    public User updateUser(@NotNull User oldUser) {
        try {
            Optional<User> user = iUser.findById(oldUser.getUserId());
            user.get().setUserBirth(oldUser.getUserBirth());
            user.get().setEmail(oldUser.getEmail());
            user.get().setUserName(oldUser.getUserName());
            user.get().setUserLastName(oldUser.getUserLastName());
            user.get().setPhoneNumber(oldUser.getPhoneNumber());
            user.get().setPassword(oldUser.getPassword());
            user.get().setPassword(oldUser.getPassword());
            return iUser.save(user.get());
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<User> findAllFollowings(Integer userId) {
        try {
            Optional<User> followers = iUser.findById(userId);
            return userStructure.formatUsers(followers.get().getUsers());
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
        iUser.save(userFollow.get());
    }

    @Override
    public void followUser(Integer userFollower, Integer userToFollow) {
        Optional<User> userFollow = iUser.findById(userFollower);
        Optional<User> newUser = iUser.findById(userToFollow);
        userFollow.get().getUsers().add(newUser.get());
        iUser.save(userFollow.get());
    }
}
