package com.github.firstproject.controller.comment;


import com.github.firstproject.service.comment.CommentService;
import com.github.firstproject.dto.comment.CommentDTO;
import com.github.firstproject.repository.comment.CommentRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    //    1. 댓글 조회
    @GetMapping("/api/comments")
    public ResponseEntity<List<CommentDTO>> comments(@PathVariable Long postId){
        //서비스에 위임
        List<CommentDTO> dtos = commentService.comments(postId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //    2. 댓글 생성
    @PostMapping("api/comments")
    public ResponseEntity<CommentDTO> create(@PathVariable Long postId,
                                             @RequestBody CommentDTO dto){
        //서비스에 위임
        CommentDTO createdDto = commentService.create(postId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //    3. 댓글 수정
    @PatchMapping("/api/comments/{comment_id}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id,
                                             @RequestBody CommentDTO dto){
        //서비스에 위임
        CommentDTO updatedDto = commentService.update(id, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
        return null;

    }
    //    4. 댓글 삭제
    @DeleteMapping("api/comments/{comments_id}")
    public ResponseEntity<CommentDto> delte(@PathVariable Long id){
        //서비스에 위임
        CommentDto deletedDto = commentService.delete(id);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }





}