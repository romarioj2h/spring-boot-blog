package com.example.accessingdatamysql.Repository;

import com.example.accessingdatamysql.Entity.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
    
}
