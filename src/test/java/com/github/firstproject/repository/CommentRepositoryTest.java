package com.github.firstproject.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByPostId(){
        /*   Case 1 : N번 게시글의 모든 댓글조회   샘플..     */
        {
            // 1. 입력 데이터 준비
            // 2. 실제 데이터
            // 3. 예상 데이터
            // 4. 비교 및 검증

        }
    }
    @Test
    void findByAuthor(){

    }

}
