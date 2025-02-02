package com.telusko.SecurityExample.repo;

import com.telusko.SecurityExample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
    Users findByEmail(String email);
}
