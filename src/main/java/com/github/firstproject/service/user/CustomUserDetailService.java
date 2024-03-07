package com.github.firstproject.service.user;

import com.github.firstproject.entity.roles.Role;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.repository.user.UserRepository;
import com.github.firstproject.entity.userDetails.CustomUserDetails;
import com.github.firstproject.entity.userRole.UserRole;
import com.github.firstproject.service.expections.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("user를 찾을 수 없습니다."));

        CustomUserDetails customUserDetails = CustomUserDetails.builder()
                .user_id(user.getUserId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getUserRoles().stream().map(UserRole::getRole).map(Role::getName).collect(Collectors.toList()))
                .build();

        return customUserDetails;
    }
}
