package com.company.ubuntuserver.ubuntu_server.services;

import com.company.ubuntuserver.ubuntu_server.services.interfaces.LoginService;
import com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers.UserNotInDataBaseException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService {
    @Override
    public boolean authentication(String email, String password) throws UserNotInDataBaseException {
        return false;
    }
}
