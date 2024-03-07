package com.github.firstproject.repository.like;

import com.github.firstproject.entity.like.Like;
import com.github.firstproject.entity.post.Post;
import com.github.firstproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByPostAndUser(Post post, User user);

}

