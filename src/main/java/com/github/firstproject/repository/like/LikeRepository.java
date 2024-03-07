package com.github.firstproject.repository.like;

import com.github.firstproject.entity.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByPostAndUser(Long postId, Long userId);

}

