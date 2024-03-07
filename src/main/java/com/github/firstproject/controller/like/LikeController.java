package com.github.firstproject.controller.like;

import com.github.firstproject.dto.like.LikeDto;
import com.github.firstproject.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/like/{postId}/{userId}")
    public ResponseEntity onLike (@PathVariable Long postId, @PathVariable Long userId) {
        LikeDto likeDto = likeService.onLike( postId, userId);
        return ResponseEntity.ok(likeDto);

    }

    @PostMapping("/like/cancel/{postId}/{userId}")
    public ResponseEntity offLike (@PathVariable Long postId, @PathVariable Long userId) {
         likeService.offLike(postId, userId);
        return ResponseEntity.ok("좋아요 취소");
    }
}

