package com.github.firstproject.repository;

import com.github.firstproject.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

}
