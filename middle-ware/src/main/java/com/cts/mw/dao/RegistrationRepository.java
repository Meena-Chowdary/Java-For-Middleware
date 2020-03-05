package com.cts.mw.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mw.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    Registration findByUsername(String username);
}