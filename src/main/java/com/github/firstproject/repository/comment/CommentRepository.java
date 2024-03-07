package com.github.firstproject.repository.comment;

import com.github.firstproject.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value= "SELECT * FROM comment WHERE post_id=:postID") //value 속성에 실행하려는 쿼리 작성
    List<Comment> findByPostId(Integer postId);
    //특정 작성자의 모든 댓글 조회
    List<Comment> findByAuthor(String author);

}