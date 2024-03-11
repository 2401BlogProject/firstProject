package com.github.firstproject.controller.comment;


import com.github.firstproject.service.comment.CommentService;
import com.github.firstproject.dto.comment.CommentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@Slf4j
public class CommentController {
    @Autowired
    private CommentService commentService;
    //    1. 댓글 조회
    @GetMapping("/api/comments/{postId}")
    public ResponseEntity<List<CommentDTO>> comments(@PathVariable Long postId){
        log.info("실향?????");
        //서비스에 위임
        List<CommentDTO> dtos = commentService.comments(postId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //    2. 댓글 생성
    @PostMapping("/api/comments")
    public ResponseEntity<CommentDTO> create(
                                             @RequestBody CommentDTO dto){
        //서비스에 위임
        CommentDTO createdDto = commentService.create(dto.getPostId(), dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //    3. 댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long commentId,
                                             @RequestBody CommentDTO dto){
        //서비스에 위임
        CommentDTO updatedDto = commentService.update(commentId, dto);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);

    }
    //    4. 댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentDTO> delete(@PathVariable Long commentId){
        //서비스에 위임
        CommentDTO deletedDto = commentService.delete(commentId);
        //결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }





}