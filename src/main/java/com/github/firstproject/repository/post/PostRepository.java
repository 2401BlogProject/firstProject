package com.github.firstproject.repository.post;

import com.github.firstproject.entity.post.PostEntity;
import com.github.firstproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {


}
