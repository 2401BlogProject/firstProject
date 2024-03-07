package com.github.firstproject.controller.like;

import com.github.firstproject.dto.like.LikeDto;
import com.github.firstproject.service.like.LikeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like/{postId}/{userId}")
    public ResponseEntity<LikeDto> onLike (@PathVariable Long postId, @PathVariable Long userId) {
        LikeDto likeDto = likeService.onLike( postId, userId);
        return ResponseEntity.ok(likeDto);
    }

    @PostMapping("/like/{postId}/{userId}")
    public ResponseEntity offLike (@PathVariable Long postId, @PathVariable Long userId) {
        likeService.offLike(postId, userId);
        return ResponseEntity.ok("좋아요 취소");
    }
}

