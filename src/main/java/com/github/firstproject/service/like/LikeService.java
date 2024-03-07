package com.github.firstproject.service.like;

import com.github.firstproject.dto.like.LikeDto;
import com.github.firstproject.entity.like.Like;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.repository.like.LikeRepository;
import com.github.firstproject.repository.post.PostRepository;
import com.github.firstproject.repository.user.UserRepository;
import com.github.firstproject.service.expections.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public LikeDto onLike( Long postId, Long userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("user를 찾을 수 없습니다.")
        );

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException("post를 찾을 수 없습니다.")
        );

        Like onLike = Like.builder().user(user).post(post).build();
        Like saveLike = likeRepository.save(onLike);

        return LikeDto.builder().likeId(saveLike.getLikeId()).user(saveLike.getUser()).post(post).build();

    }

    public void offLike(Long postId, Long userId) {
        Like like = likeRepository.findByPostAndUser(postId, userId).orElseThrow(
                () -> new NotFoundException("좋아요를 찾을 수 없습니다.")
        );

        likeRepository.delete(like);
    }
}
