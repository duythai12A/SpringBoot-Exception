package com.example.springbootexeption.repository;

import com.example.springbootexeption.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
