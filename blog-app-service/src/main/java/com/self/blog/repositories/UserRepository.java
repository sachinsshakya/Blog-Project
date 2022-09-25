package com.self.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
