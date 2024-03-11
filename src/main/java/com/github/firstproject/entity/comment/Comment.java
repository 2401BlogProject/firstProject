package com.github.firstproject.entity.comment;

import com.github.firstproject.dto.comment.CommentDTO;
import com.github.firstproject.entity.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;


@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId; //대표키
    @ManyToOne // Post 필드에 대한 매핑을 @ManyToOne 으로 수정
    @JoinColumn(name = "post_id") // 외래키 컬럼 지정
    private Post post;
    @Column
    private String author; //댓글 단 사람
    @Column
    private String content; // 댓글 내용

    public static Comment createComment(CommentDTO dto, Post post) {
        // 예외 발생
        if (Objects.nonNull(dto.getId()))
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (!Objects.equals(dto.getPostId(), post.getId()))
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 idrk 잘못됐습니다.");
        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                post,
                dto.getAuthor(),
                dto.getContent()
        );
    }

    public void patch(CommentDTO dto) {
        //예외 발생
        if (this.commentId != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다.");
        //객체 갱신
        if(dto.getAuthor() != null) //수정할 닉네임 데이터
            this.author = dto.getAuthor(); //내용 반영
        if(dto.getContent() !=null) //수정할 본문데이터
            this.content = dto.getContent();
    }
}