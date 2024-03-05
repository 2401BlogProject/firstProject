package com.github.firstproject.config.security;

import com.github.firstproject.entity.roles.Role;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final UserDetailsService userDetailsService;

    private long tokenVailidMillisecond = 1000L * 60 * 60;

    public String resolveToken (HttpServletRequest request) {
        String bearerToken = request.getHeader("AUTHORIZATION_HEADER");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public String createToken (String email, List<Role> roles) {
        Date now = new Date();

        return Jwts.builder()
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenVailidMillisecond))
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecreteKey())
                .compact();
    }

    public Authentication getAuthentication (String token) {
        String userEmail = getUserEmail(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);


        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validation(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecreteKey()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUserEmail (String token) {
        return Jwts.parser().setSigningKey(jwtProperties.getSecreteKey()).parseClaimsJws(token).getBody().getSubject();
    }

}
