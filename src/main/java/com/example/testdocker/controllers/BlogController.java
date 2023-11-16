package com.example.testdocker.controllers;

import com.example.testdocker.entities.Blog;
import com.example.testdocker.repositories.BlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    @Autowired
    BlogRespository blogRespository;

    @GetMapping("/blog")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Optional<Blog> index(@PathVariable Integer id){
        return blogRespository.findById(id);
    }
}
