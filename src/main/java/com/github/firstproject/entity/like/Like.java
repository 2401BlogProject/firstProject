package com.github.firstproject.entity.like;

import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post post;

}
