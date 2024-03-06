package com.github.firstproject.service.post;

import com.github.firstproject.dto.post.PostDTO;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.repository.post.PostRepository;
import com.github.firstproject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUserEmail(String email) {
        User user = userRepository.searchByEmail(email);
        return user != null ? user.getPosts() : null;
    }

    public Post createPost(PostDTO postDTO) {
        Optional<User> userOptional = userRepository.findById(postDTO.getUserId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setUser(user);
            return postRepository.save(post);
        } else {
            // 사용자가 존재하지 않는 경우에 대한 예외 처리 또는 메시지 반환
            return null;
        }
    }

    public Post updatePost(Long postId, PostDTO postDTO) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Optional<User> userOptional = userRepository.findById(postDTO.getUserId());

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                Post post = optionalPost.get();
                post.setTitle(postDTO.getTitle());
                post.setContent(postDTO.getContent());
                post.setUser(user);
                return postRepository.save(post);
            } else {
                // 사용자가 존재하지 않는 경우에 대한 예외 처리 또는 메시지 반환
                return null;
            }
        } else {
            // 게시물이 존재하지 않는 경우에 대한 예외 처리 또는 메시지 반환
            return null;
        }
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
