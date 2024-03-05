package com.github.firstproject.entity.post;

import com.github.firstproject.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// JPA 엔터티 클래스임을 나타내는 어노테이션입니다. 이 클래스는 데이터베이스의 테이블과 매핑됩니다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @Id
    // 엔터티 클래스에서 사용되는 기본 키를 나타내는 어노테이션입니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키의 값을 자동으로 생성하는 전략을 설정하는 어노테이션입니다.
    // 여기서는 데이터베이스가 자동 증가(Auto Increment)되는 경우를 사용합니다.
    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;


}
