package com.example.testdocker.repositories;

import com.example.testdocker.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Integer> {

}