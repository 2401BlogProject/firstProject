package com.github.firstproject.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long postId;
    private String title;
    private String content;
    private String author;
    private Long userId;

}
