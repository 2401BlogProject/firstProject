package com.github.firstproject.controller;


import com.github.firstproject.entity.post.PostEntity;
import com.github.firstproject.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Optional<PostEntity> getPostById(@PathVariable int postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostEntity savePost(@RequestBody PostEntity postEntity) {
        return postService.savePost(postEntity);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
    }
}
