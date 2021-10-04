package com.dh.Clinica.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Set<GrantedAuthority> autorizaciones = new HashSet<>();
        //Role rol = new Role("USER", null);
        GrantedAuthority autorizacionUSER = new SimpleGrantedAuthority("ROLE_USER");
        GrantedAuthority autorizacionADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
        autorizaciones.add(autorizacionUSER);
        autorizaciones.add(autorizacionADMIN);

        User user = new  User("admin","{noop}admin",true,true,true,true,autorizaciones);

        Set<GrantedAuthority> autorizaciones1 = new HashSet<>();
        autorizaciones1.add(autorizacionUSER);
        User user1 = new User("user", "{noop}user", true,true,true,true,autorizaciones1 );

        if(s.equals(user.getUsername())){
            return user;
        }

        return user1;
    }
}
