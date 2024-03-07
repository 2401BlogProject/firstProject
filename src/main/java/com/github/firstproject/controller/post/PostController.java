package com.github.firstproject.controller.post;

import com.github.firstproject.dto.post.PostDTO;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();

        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(posts);
        }

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<?> getPostsByUserEmail(@RequestParam(name = "author_email", required = false) String email) {
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("이메일이 제공되지 않았거나 비어있습니다.");
        }

        List<PostDTO> posts = postService.getPostsByUserEmail(email);

        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시물이 없습니다.");
        } else {
            return ResponseEntity.ok(posts);
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody PostDTO postDTO) {
        Post createdPost = postService.createPost(postDTO);

        if (createdPost != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 성공적으로 생성되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시물 생성에 실패했습니다.");
        }
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO) {
        Post updatedPost = postService.updatePost(postId, postDTO);

        if (updatedPost != null) {
            return ResponseEntity.ok("게시물이 성공적으로 업데이트되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시물 업데이트에 실패했습니다.");
        }
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        boolean deleted = postService.deletePost(postId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("게시물 삭제에 실패했습니다.");
        }
    }
}