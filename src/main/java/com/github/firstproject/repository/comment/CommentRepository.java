package com.github.firstproject.repository.comment;

import com.github.firstproject.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Query(value = "SELECT * FROM comment WHERE post_id = :postId", nativeQuery = true)
//    @Query("SELECT c FROM Comment c WHERE c.id = :id")
//    List<Comment> findByPostId(@Param("id")Long postId);
    List<Comment> findByPostId(Long postId);

    List<Comment> findAllByPostId(Long postId);

    //특정 작성자의 모든 댓글 조회
    List<Comment> findByAuthor(String author);
    Optional<Comment> findById(Long id);

}