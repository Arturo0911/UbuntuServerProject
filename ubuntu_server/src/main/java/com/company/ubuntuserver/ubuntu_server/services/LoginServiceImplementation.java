package com.company.ubuntuserver.ubuntu_server.services;

import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.services.interfaces.LoginService;
import com.company.ubuntuserver.ubuntu_server.utilities.JWTUtil;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.NotSupportedEncodingException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotLoggedException;
import com.company.ubuntuserver.ubuntu_server.utilities.structure.UserStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class LoginServiceImplementation implements LoginService {

    @Autowired
    IUser iUser;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserStructure userStructure;


    @Override
    public User authentication(String email, String password) throws UserNotInDataBaseException {

        try{
            User user = iUser.findUserByEmail(email);
            if (userStructure.matchPassword(password,user.getPassword())){
                return user;
            }else{
                throw new UserNotInDataBaseException("User not found in database");
            }

        }catch (Exception e){
            e.printStackTrace();
            return null ;
        }

    }

    @Override
    public String createJWT(String email) throws NotSupportedEncodingException {
        return jwtUtil.generateToken(email);
    }

    @Override
    public HashMap<Object, Object> getJWTFromRequest(HttpServletRequest request) throws NotSupportedEncodingException, UserNotLoggedException {
        return null;
    }

    /**
     *
     * @param email
     * @return User object
     */
    @Override
    public User findByEmail(String email) {
        return iUser.findUserByEmail(email);
    }
}
