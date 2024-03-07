package com.github.firstproject.service.auth;

import com.github.firstproject.config.security.JwtProvider;
import com.github.firstproject.dto.user.UserDto;
import com.github.firstproject.entity.roles.Role;
import com.github.firstproject.entity.user.User;
import com.github.firstproject.entity.userRole.UserRole;
import com.github.firstproject.repository.roles.RoleRepository;
import com.github.firstproject.repository.user.UserRepository;
import com.github.firstproject.repository.userRoles.UserRolesRepository;
import com.github.firstproject.service.expections.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRolesRepository userRolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Transactional
    public Boolean sign(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            return false;
        }

        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(
                () -> new NotFoundException("Role를 찾을 수 없습니다")
        );


        User newUser = User.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();

        UserRole userRole = UserRole.builder().user(newUser).role(role).build();

//        userRolesRepository.save(userRole);
        userRepository.save(newUser);
        return true;
    }


    public boolean login(UserDto userDto, HttpServletResponse response) {
        try {
            log.info("UserDto email = {}", userDto.getEmail());
            log.info("UserDto password = {}", userDto.getPassword());


            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

            log.info("여기까지 진행");

            userRepository.findByEmail(userDto.getEmail()).orElseThrow(
                    () -> new NotFoundException("유저를 찾을 수 없습니다.")
            );

            Role role = roleRepository.findByName("ROLE_USER").orElseThrow(
                    () -> new NotFoundException("역할이 없습니다")
            );

            String token = "Bearer " + jwtProvider.createToken(userDto.getEmail(), List.of(role));
            response.addHeader("AUTHORIZATION_HEADE", token);

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
