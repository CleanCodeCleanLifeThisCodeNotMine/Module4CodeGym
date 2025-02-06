package com.example.cruddemo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider {

    private final JwtUtils jwtUtils;

    public JwtAuthenticationProvider(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public boolean validateToken(String token) {
        return !jwtUtils.isTokenExpired(token);
    }

    public String getUsernameFromToken(String token) {
        return jwtUtils.getUsernameFromToken(token);
    }
}
