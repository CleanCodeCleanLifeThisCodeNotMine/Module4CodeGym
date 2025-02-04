package org.example.blogg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("org.example.blogg.repository")
@ComponentScan(basePackages = "org.example.blogg")
public class ApplicationConfig {
}
