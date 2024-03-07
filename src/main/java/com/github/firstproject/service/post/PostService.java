package com.github.firstproject.service.post;

import com.github.firstproject.dto.post.PostDTO;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.repository.post.PostRepository;
import com.github.firstproject.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(Post::toDTO)
                .collect(Collectors.toList());
    }


    public List<PostDTO> getPostsByUserEmail(String email) {
        return Post.findByUserEmail(userRepository, email).stream()
                .map(Post::toDTO)
                .collect(Collectors.toList());
    }

    public Post createPost(PostDTO postDTO) {
        if (postDTO.getUserId() == null) {
            // 사용자 ID가 없는 경우에 대한 처리 또는 예외 발생
            return null;
        }

        Optional<User> userOptional = userRepository.findById(postDTO.getUserId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            post.setAuthor(postDTO.getAuthor());
            post.setUser(user);
            return postRepository.save(post);
        } else {
            // 사용자가 존재하지 않는 경우에 대한 예외 처리 또는 메시지 반환
            return null;
        }
    }

    public Post updatePost(Long postId, PostDTO postDTO) {
        if (postId == null) {
            // 게시물 ID가 없는 경우에 대한 처리 또는 예외 발생
            return null;
        }

        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setTitle(postDTO.getTitle());
            post.setContent(postDTO.getContent());
            return postRepository.save(post);
        } else {
            // 게시물이 존재하지 않는 경우에 대한 예외 처리 또는 메시지 반환
            return null;
        }
    }

    public boolean deletePost(Long postId) {
        try {
            postRepository.deleteById(postId);
            return true; // 삭제 성공
        } catch (Exception e) {
            // 예외가 발생하면 삭제 실패
            return false;
        }
    }
}
