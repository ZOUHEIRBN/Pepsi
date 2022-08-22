package com.example.demo.Services;

import java.util.ArrayList;


import com.example.demo.Entity.HR;
import com.example.demo.Repostory.IHR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HRService implements UserDetailsService {
    
    @Autowired
    IHR hrrepo;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HR user = hrrepo.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
    
}