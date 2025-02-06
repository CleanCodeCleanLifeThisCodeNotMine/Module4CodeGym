package com.example.cruddemo.controller;

import com.example.cruddemo.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtUtils jwtUtils;

    @Autowired
    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest loginRequest) {
        // Kiểm tra thông tin đăng nhập (đơn giản là username là "user" và mật khẩu là "password")
        if ("user".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            // Tạo và trả về JWT token
            return jwtUtils.generateToken(loginRequest.getUsername());
        }
        throw new RuntimeException("Invalid username or password");
    }
}

class UserLoginRequest {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
