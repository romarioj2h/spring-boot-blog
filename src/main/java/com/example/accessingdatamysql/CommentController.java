package com.example.accessingdatamysql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(path = "/create")
    public Comment create(@RequestParam String email, @RequestParam String content, @RequestParam Integer postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new RuntimeException("Post not found");
        }
        Comment comment = new Comment();
        comment.setPost(post.get());
        comment.setContent(content);
        comment.setEmail(email);
        commentRepository.save(comment);
        return comment;
    }
}
