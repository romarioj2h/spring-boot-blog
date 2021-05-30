package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.Entity.Post;
import com.example.accessingdatamysql.Repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    
    @PostMapping(path = "/create")
    public Post create(@RequestParam String title, @RequestParam String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postRepository.save(post);
        return post;
    }

    @GetMapping(path = "/")
    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }
}
