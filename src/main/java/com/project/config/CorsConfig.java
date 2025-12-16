package com.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // INCLUINDO A PORTA 81 QUE VOCÊ ESTÁ USANDO NO FRONTEND
                .allowedOrigins("http://localhost:81",
                        "http://localhost:8081", // Opcional, para testes internos
                        "http://127.0.0.1:5500", // Manter se usar Live Server
                        "http://localhost")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}