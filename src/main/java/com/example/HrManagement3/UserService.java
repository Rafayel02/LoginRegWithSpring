package com.example.HrManagement3;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService implements UserDetailsService {

    private List<HR> users = new ArrayList<>();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        for(HR user: users) {
            if(user.getUsername().equals(s)) {
                return user;
            }
        }
        return null;
    }

    public void register(String username, String password) {
        users.add(
                new HR(
                        username,
                        password,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                )
        );
        System.out.println("reg");
    }

}
