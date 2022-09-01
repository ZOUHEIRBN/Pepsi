package com.example.demo.Services;


import java.util.List;

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
        HR hr = hrrepo.findByUsername(username);
        UserDetails user = User.withUsername(hr.getUsername())
        .password(hr.getPassword())
        .authorities(hr.getAuthorities())
        .build();
        for(var u: user.getAuthorities()){
            System.out.println(u);
        }
        return user;
    }

    public HR findByUsername(String username){
        return hrrepo.findByUsername(username);
    }
    
    public void addHR(HR hr){
        hrrepo.save(hr);
    }

    public List<Object> getUserRoles(Long userId){
        return null; //hrrepo.findRolesById(userId);
    }
}