package com.github.firstproject.service.post;

import com.github.firstproject.dto.PostDTO;
import com.github.firstproject.entity.post.PostEntity;
import com.github.firstproject.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public PostEntity getPostById(int postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public PostEntity createPost(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setContent(postDTO.getContent());
        return postRepository.save(postEntity);
    }

    public PostEntity updatePost(int postId, PostDTO postDTO) {
        PostEntity existingPost = postRepository.findById(postId).orElse(null);

        if (existingPost != null) {
            existingPost.setTitle(postDTO.getTitle());
            existingPost.setContent(postDTO.getContent());
            return postRepository.save(existingPost);
        }

        return null;
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
