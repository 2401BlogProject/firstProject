package com.github.firstproject.service.post;

import com.github.firstproject.entity.post.PostEntity;
import com.github.firstproject.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<PostEntity> getPostById(int postId) {
        return postRepository.findById(postId);
    }

    public PostEntity savePost(PostEntity postEntity) {
        return postRepository.save(postEntity);
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
