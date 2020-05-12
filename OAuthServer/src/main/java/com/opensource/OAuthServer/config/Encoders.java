package com.opensource.OAuthServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Encoders {
    // https://dzone.com/articles/secure-spring-rest-with-spring-security-and-oauth2
    @Bean
    public PasswordEncoder oauthClientSecretEncoder(){
        return new BCryptPasswordEncoder();
    }
}
