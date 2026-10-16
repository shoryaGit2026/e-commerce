package com.emart.user_module.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.user_module.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
