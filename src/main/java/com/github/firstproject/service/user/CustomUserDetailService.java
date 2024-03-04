package com.github.firstproject.service.user;

import com.github.firstproject.repository.user.User;
import com.github.firstproject.repository.user.UserRepository;
import com.github.firstproject.service.expections.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("user를 찾을 수 없습니다."));

        return User.builder()
                .email(email).userId(user.getUserId())
                .passowrd(user.getPassword()).userRoles(user.getUserRoles())
                .build();
    }
}
