package com.example.cruddemo.config;

import com.example.cruddemo.security.JwtAuthenticationFilter;
import com.example.cruddemo.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public SecurityConfig(JwtAuthenticationProvider jwtAuthenticationProvider) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF cho đơn giản khi thử nghiệm
                .authorizeRequests()
                .requestMatchers("/api/auth/**").permitAll()  // Cho phép đăng nhập không cần JWT
                .anyRequest().authenticated()  // Bảo vệ các endpoint khác
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtAuthenticationProvider), UsernamePasswordAuthenticationFilter.class); // Đặt JWT filter trước UsernamePasswordAuthenticationFilter

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Cấu hình người dùng trong bộ nhớ với thông tin đăng nhập
        return username -> {
            if ("user".equals(username)) {
                return User.withUsername("user")
                        .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build();
            }
            throw new RuntimeException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
