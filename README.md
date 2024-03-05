# 네이버_실장님 프로젝트_BE

## 1. 프로젝트 방향성 설계

---

- **얻어야 가야하는 부분**
    1. 기본적인 백엔드 웹 개발 흐름을 파악
    2. 스스로 문제를 정의하고, 해결하는 능력
    3. BE 분들과 소통하며 능력
- **프로젝트 전체 방향성 설계**
    1. 지루하고, 삽질이 많은 세팅부터 시작하기보다, **실제 동작하는 걸 보여주고, 직접 구현함으로써 흥미를 최대한 가져간다.**
    2. 코드 개발 이외의 **테스팅 툴이나 협업, 비즈니스 문제를 정의하는 능력도 배양한다.**

## 2. 프로젝트 진행 구체화

---

- **<1>** **진행 목표**
    1. 지난 4주간 배운 JAVA,  DB를 바탕으로 **실제 백엔드 애플리케이션을 직접 만들어본다.**
    2. 세팅, 스프링 복잡한 원리보다, **클론코딩으로 직접 구현해보며 학습 동기 유발한다.**
    3. 작지만, 조금씩 손수 구현해보며, 중간중간 기술 바탕이 되는 기본 이론들을 익혀본다.
- **<2> 진행 내용**
    - **진행 기간**: ~ 1 week
    - **진행 방식**
    1. 프론트가 구현된 **게시판 깡통 web page가 제공**되고, **해당 web Page가 필요한 API를 구현한다.
    - github: https://github.com/dev-owen/fe-dashboard
    - demo: https://fe-dashboard-gamma.vercel.app/**
- **<3> 프로젝트 제공 기능**
    - 게시판 기능
        
        
        | 기능 | 상세 | 참고 |
        | --- | --- | --- |
        | 회원 | 1. 이메일 비밀번호 입력하여 회원가입 API
        2. 이메일 비밀번호 입력하여 접속하는 API
        3. 접속된 유저 로그아웃 |  |
        | 조회 | 1. 게시물 전체 조회하는 API
        2. 작성자 이메일을 통해 특정 게시물들을 검색하는 API
        3. 댓글을 조회하는 API |  |
        | 생성 | 1. 댓글을 새롭게 만들 수 있는 API
        2. 게시물을 새롭게 만들 수 있는 API |  |
        | 수정 | 1. 기존 댓글의 글을 수정하는 API
        2. 게시물을 새롭게 수정할 수 있는 API |  |
        | 삭제 | 1. 게시물을 삭제하는 API
        2. 댓글을 삭제하는 API |  |
        | 심화 | 1. 이메일과 같이 댓글 좋아요를 할 수 있는 기능  |  |
    - 게시판 기능 API 인터페이스 스펙
        1. 이메일 비밀번호 입력하여 회원가입 API
            - HTTP 메소드: POST
            - 엔드포인트: /api/signup
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "email": "user@example.com",
                  "password": "user_password"
                }
                ```
                
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "message": "회원가입이 완료되었습니다."
                }
                ```
                
        2. 이메일 비밀번호 입력하여 접속하는 API
            - HTTP 메소드: POST
            - 엔드포인트: /api/login
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "email": "user@example.com",
                  "password": "user_password"
                
                ```
                
            - 응답 본문 HTTP ( token 해더로 )
                
                ```sql
                HTTP/1.1 200 OK
                Content-Type: application/json
                Authorization: Bearer your_access_token_here
                
                {
                  "message": "로그인이 성공적으로 완료되었습니다."
                }
                ```
                
        3. 접속된 유저 로그아웃
            - HTTP 메소드: POST
            - 엔드포인트: /api/logout
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "email": "user@example.com"
                }
                ```
                
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "message": "로그아웃되었습니다."
                }
                ```
                
        4. 게시물 전체 조회하는 API
            - HTTP 메소드: GET
            - 엔드포인트: /api/posts
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "posts": [
                    {
                      "id": 1,
                      "title": "게시물 제목",
                      "content": "게시물 내용",
                      "author": "작성자",
                      "created_at": "작성일시"
                    },
                    {
                      "id": 2,
                      "title": "게시물 제목",
                      "content": "게시물 내용",
                      "author": "작성자",
                      "created_at": "작성일시"
                    },
                    ...
                  ]
                }
                
                ```
                
        5. 작성자 이메일을 통해 특정 게시물들을 검색하는 API
            - HTTP 메소드: GET
            - 엔드포인트: /api/posts/search
            - 쿼리 파라미터: ?author_email=**[user@example.com](mailto:user@example.com)**
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "posts": [
                    {
                      "id": 1,
                      "title": "게시물 제목",
                      "content": "게시물 내용",
                      "author": "작성자",
                      "created_at": "작성일시"
                    },
                    {
                      "id": 3,
                      "title": "게시물 제목",
                      "content": "게시물 내용",
                      "author": "작성자",
                      "created_at": "작성일시"
                    },
                    ...
                  ]
                }
                
                ```
                
        6. 댓글을 조회하는 API
            - HTTP 메소드: GET
            - 엔드포인트: /api/comments
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "comments": [
                    {
                      "id": 1,
                      "content": "댓글 내용",
                      "author": "작성자",
                      "post_id": 1,
                      "created_at": "작성일시"
                    },
                    {
                      "id": 2,
                      "content": "댓글 내용",
                      "author": "작성자",
                      "post_id": 1,
                      "created_at": "작성일시"
                    },
                    ...
                  ]
                }
                ```
                
        7. 댓글을 새롭게 만들 수 있는 API
            - HTTP 메소드: POST
            - 엔드포인트: /api/comments
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "content": "댓글 내용",
                  "author": "작성자",
                  "post_id": 1
                }
                ```
                
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "message": "댓글이 성공적으로 작성되었습니다."
                }
                ```
                
        8. 게시물을 새롭게 만들 수 있는 API
            - HTTP 메소드: POST
            - 엔드포인트: /api/posts
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "title": "게시물 제목",
                  "content": "게시물 내용",
                  "author": "작성자"
                }
                ```
                
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "message": "게시물이 성공적으로 작성되었습니다."
                }
                ```
                
        9. 기존 댓글의 글을 수정하는 API
            - HTTP 메소드: PUT
            - 엔드포인트: /api/comments/:comment_id
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "content": "수정된 댓글 내용"
                }
                ```
                
            - 응답 본문(JSON 형식):
                
                ```json
                {
                  "message": "댓글이 성공적으로 수정되었습니다."
                }
                ```
                
        10. 게시물을 새롭게 수정할 수 있는 API
            - HTTP 메소드: PUT
            - 엔드포인트: /api/posts/:post_id
            - 요청 본문(JSON 형식):
                
                ```json
                {
                  "title": "수정된 게시물 제목",
                  "content": "수정
                }
                ```
                
- **<4> 프로젝트 사용 기술**
    1. Spring Web MVC
    2. Java / Gradle로 패키지 관리
    3. Spring module 시작
    4. Spring JPA 기초
    5. Spring Logging
    6. PostMan 툴 사용하여 Test 하기
    7. Spring Application 빌드 / 실행
- **<5> 프로젝트 진행 순서**
    1. 아무 게시물이 없는 깡통 프론트 web page를 보여주고, 우리의 요구사항을 간단하게 정의한다.
    2. Spring Module을 만드는 방법과 gradle로 패키지 관리하는 방법, 빌드/실행 하는 방법을 배운다.
    3. DB를 연결하지 않은 채, Spring MVC 웹계층을 통해 결과물을 보여주고 , 직렬화/역직렬화를 학습한다.
    4. Spring Web MVC의 기본 개념인 Controller, DTO 등을 소개하고 구현한다.
    5. Post man / Spring Logging  을 이용하여 Spring Web 구현한 부분을 테스팅하고 로그 확인한다
    6. RDB 설계부분 설명, DB와 매핑하는 Spring Data JPA를 이용하여 DB의 데이터를 전달한다.
    7. Spring Data JPA를 이용, 모든 CRUD API를 같이 구현해보고 완성된 웹페이지를 구축한다.
