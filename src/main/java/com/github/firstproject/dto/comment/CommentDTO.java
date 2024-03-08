package com.github.firstproject.dto.comment;

import com.github.firstproject.entity.comment.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDTO {
    private Long id;
    private Long postId;
    private String author;
    private String content;

    public CommentDTO(Long id, Object id1, String author, String content) {
    }

    public static CommentDTO createCommentDTO(Comment comment) {
        return new CommentDTO(
                comment.getCommentId(),
                comment.getPost().getId(),
                comment.getAuthor(),
                comment.getContent()
        );
    }

}