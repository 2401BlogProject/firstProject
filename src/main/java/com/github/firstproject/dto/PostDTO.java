package com.github.firstproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class PostDTO {

    private int postId;
    private String title;
    private String content;
}
