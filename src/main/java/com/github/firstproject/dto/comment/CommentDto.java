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
public class CommentDto {
    private int id;
    private int postId;
    private String author;
    private String content;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getPost().getId(),
                comment.getAuthor(),
                comment.getContent()
        );
    }

}
