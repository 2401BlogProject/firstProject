//package com.github.firstproject.api;
//
//import com.github.firstproject.dto.CommentDto;
//import com.github.firstproject.entity.Post;
//import com.github.firstproject.respository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//public class PostController {
//    @Autowired
//    private PostRepository postRepository;
//    @Autowired
//    private CommentService commentService ;
//
//    //댓글 뷰 페이지 삽입하기
//    @GetMapping("/api/post/{post_id}")
//    public String show(@PathVariable Long id, Model model){
//        log.info("id = " +id);
//        //1. id를 조회해 데이터 가져오기
//        Post postEntity = postRepository.findById(id).orElse(null);
//        List<CommentDto> commentsDtos = commentService.comments(id);
//        //2. 모델에 데이터 등록하기
//        model.addAttribute("article", articleEntity);
//        //3. 뷰 페이지 설정하기
//        return "posts/show";
//    }
//}
