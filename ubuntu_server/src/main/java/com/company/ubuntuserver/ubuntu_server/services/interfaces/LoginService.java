package com.company.ubuntuserver.ubuntu_server.services.interfaces;

import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;

public interface LoginService {

    boolean authentication(String email, String password) throws UserNotInDataBaseException;
}
