package com.cts.mw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mw.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}