package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.entities.User;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.NotSupportedEncodingException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotLoggedException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

public interface LoginService {

    User authentication(String email, String password) throws UserNotInDataBaseException;

    String createJWT(String email) throws NotSupportedEncodingException;

    HashMap<Object, Object> getJWTFromRequest(HttpServletRequest request) throws NotSupportedEncodingException, UserNotLoggedException;

    User findByEmail(String email);

}
