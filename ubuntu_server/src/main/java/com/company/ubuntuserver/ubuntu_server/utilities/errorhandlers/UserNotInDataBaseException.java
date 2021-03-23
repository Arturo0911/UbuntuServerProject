package com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers;

public class UserNotInDataBaseException extends Exception {

    public UserNotInDataBaseException(String message){
        super(message);
    }
}
