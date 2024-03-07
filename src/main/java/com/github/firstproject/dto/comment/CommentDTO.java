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
    private int id;
    private int postId;
    private String author;
    private String content;

    public static CommentDTO createCommentDTO(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getPost().getId(),
                comment.getAuthor(),
                comment.getContent()
        );
    }

}