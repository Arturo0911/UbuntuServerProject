package com.company.ubuntuserver.ubuntu_server.security;

import org.jasypt.util.text.BasicTextEncryptor;

import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {

    /**
     * TODO:
     *      - Generate encryption on insertions into DB.
     *      - Decrypt data for post decrypt for post match
     */

    private BasicTextEncryptor textEncryptor;

    public EncryptionUtils(){
        textEncryptor = new BasicTextEncryptor();
        //textEncryptor.setPassword("L1ke X Zt0ne ");
        textEncryptor.setPassword("L1ke");
    }


    public String encryptData(String data){
        return textEncryptor.encrypt(data);
    }
    public String decryptData(String dataEncrypted){
        return textEncryptor.decrypt(dataEncrypted);
    }


}
