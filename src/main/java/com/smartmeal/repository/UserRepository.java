package com.smartmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartmeal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}