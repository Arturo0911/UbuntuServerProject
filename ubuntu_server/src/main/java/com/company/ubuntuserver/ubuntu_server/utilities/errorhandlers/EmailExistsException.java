package com.company.ubuntuserver.ubuntu_server.utilities.errorhandlers;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message){
        super(message);
    }
}
