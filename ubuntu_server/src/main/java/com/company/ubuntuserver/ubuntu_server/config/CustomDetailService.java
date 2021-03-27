package com.company.ubuntuserver.ubuntu_server.config;

import com.company.ubuntuserver.ubuntu_server.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.company.ubuntuserver.ubuntu_server.entities.User;

import java.util.ArrayList;

@Service("customDetailService")
public class CustomDetailService implements UserDetailsService {


    @Autowired
    private LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if (email.trim().isEmpty()){
            throw new UsernameNotFoundException("Email field is empty");
        }
        User user = loginService.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not in database");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
