package com.github.firstproject.service;


import com.github.firstproject.dto.CommentDto;
import com.github.firstproject.entity.Comment;
import com.github.firstproject.entity.Post;
import com.github.firstproject.repository.CommentRepository;
import com.github.firstproject.respository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository; //댓글 라파지터리 객체 주입
    @Autowired
    private PostRepository postRepository; //게시글 리파지터리 객체 주입

    public List<CommentDto> comments(Long postId) {
        // 1. 댓글 조회
        List<Comment> comments = commentRepository.findByPostId(postId);
        // 2. 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i =0; i< comments.size(); i++){
            Comment c = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(c);
            dtos.add(dto);
        }
        // 3. 결과 변환
        return commentRepository.findByPostId(postId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());


    }


   @Transactional
   public CommentDto create(Long postId, CommentDto dto) {
        // 1. 게시글 조회 및 예외 발생
       Post post = postRepository.findById(postId)
               .orElseThrow(()-> new IllegalArgumentException("댓글 생성 실패!" +
                       "대상 게시글이 없습니다."));
        // 2. 댓글 엔티티 생성
       Comment comment = Comment.createComment(dto, post);
       // 3. 댓글 엔티티를 DB에 저장
       Comment created = commentRepository.save(comment);
       // 4. DTO로 변환해 반환
       return CommentDto.createCommentDto(created);

    }

    public CommentDto update(Long id, CommentDto dto) {
        @Transactional
         public CommentDto update(Long id, CommentDto dto){
            // 1. 댓글 조회 및 예외 발생
            Comment target = commentRepository.findById(id)
                    .orElseThrow(()-> new IllegalArgumentException("댓글 수정 실패!"+"대상 댓글이 없습니다."));
            // 2. 댓글 수정
            target.patch(dto);
            // 3. DB로 갱신
            Comment updated = commentRepository.save(target);
            // 4. 댓글 엔티티를 DTO로 변환 및 반환
            return CommentDto.createCommentDto(updated);
        }
    }

    @Transactional
    public CommentDto delete(Long id) {
        // 1. 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById()
                .orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패!"+
                        "대상이 없습니다."));
        // 2. 댓글 삭제
        commentRepository.delete(target);
        // 3.삭제 댓글을 DTO로 변환 및 반환
        return CommentDto.createCommentDto(target);
    }
}
