package com.telusko.SecurityExample.service;

import com.telusko.SecurityExample.model.CustomUserDetails;
import com.telusko.SecurityExample.model.Users;
import com.telusko.SecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(identifier);

        if (user == null) {
            user = userRepo.findByEmail(identifier);
        }

        if (user == null) {
            System.out.println("User not found: " + identifier);
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User found: " + identifier);

        return new CustomUserDetails(user);
    }
}
