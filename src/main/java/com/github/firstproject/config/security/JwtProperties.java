package com.github.firstproject.config.security;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    private String issuer = "dktmskf96@gmail.com";
    private String secreteKey = "supercoding";
}
