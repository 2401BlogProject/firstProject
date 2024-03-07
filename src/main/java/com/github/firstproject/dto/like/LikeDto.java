package com.github.firstproject.dto.like;

import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class LikeDto {

    private Long likeId;
    private User user;
    private Post post;
}

