package com.github.firstproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String author;
}
