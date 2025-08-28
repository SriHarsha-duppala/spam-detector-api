package com.example.spamdetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpamdetectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpamdetectorApplication.class, args);
    }

    // Add this CORS bean
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // allow all endpoints
                        .allowedOrigins("https://68b06d825ba07873f3a6e674--zippy-meerkat-03e99d.netlify.app/"); // allow frontend
            }
        };
    }
}
