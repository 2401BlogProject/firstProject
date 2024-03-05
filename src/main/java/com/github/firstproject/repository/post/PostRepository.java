package com.github.firstproject.repository.post;

import com.github.firstproject.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
