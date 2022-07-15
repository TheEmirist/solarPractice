package com.practice.notavito.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.notavito.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
