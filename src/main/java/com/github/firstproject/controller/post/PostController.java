package com.github.firstproject.controller.post;


import com.github.firstproject.dto.post.PostDTO;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts/search")
    public List<Post> getPostsByUserEmail(@RequestParam String email) {
        return postService.getPostsByUserEmail(email);
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO) {
        return postService.updatePost(postId, postDTO);
    }

    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }
}
