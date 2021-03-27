package com.company.ubuntuserver.ubuntu_server.config;

import com.company.ubuntuserver.ubuntu_server.daos.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private IUser iUser;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.company.ubuntuserver.ubuntu_server.entities.User user = iUser.findUserByEmail(email);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        UserDetails userDetails = new User(user.getEmail(), user.getPassword(),roles);

        return userDetails;
    }
}
