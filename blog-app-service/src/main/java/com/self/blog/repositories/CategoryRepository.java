package com.self.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.self.blog.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
