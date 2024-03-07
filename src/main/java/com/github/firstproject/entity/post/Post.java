package com.github.firstproject.entity.post;

import com.github.firstproject.dto.post.PostDTO;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.repository.user.UserRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String content;
    private String author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return postId;
    }
    public PostDTO toDTO() {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(this.postId);
        postDTO.setTitle(this.title);
        postDTO.setContent(this.content);
        postDTO.setAuthor(this.author);
        return postDTO;
    }

    public static List<Post> findByUserEmail(UserRepository userRepository, String email) {
        List<Post> posts = new ArrayList<>();

        // 이메일로 유저 찾기
        Optional<User> optionalUser = userRepository.findByEmail(email);

        // 유저가 존재하면 해당 유저의 포스트 가져오기
        if (optionalUser.isPresent()) {
            posts = optionalUser.get().getPosts();
        }

        return posts;
    }
}
