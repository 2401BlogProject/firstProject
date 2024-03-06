package com.github.firstproject.controller.auth;

import com.github.firstproject.dto.user.UserDto;
import com.github.firstproject.service.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/sign")
    public ResponseEntity sign (@RequestBody UserDto userDto) {
        boolean isSuccess = authService.sign(userDto);
        return isSuccess ?
                ResponseEntity.ok("회원가입이 되었습니다.") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입에 실패헸습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody UserDto userDto, HttpServletResponse response) {
        boolean isSuccess = authService.login(userDto, response);
        return isSuccess ?
                ResponseEntity.ok("로그인 되었습니다.") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("로그인에 실패했습니다.");
    }
}
