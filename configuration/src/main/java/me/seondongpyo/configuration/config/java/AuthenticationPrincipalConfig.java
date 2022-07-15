package me.seondongpyo.configuration.config.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationPrincipalConfig {

    @Bean
    public AuthService authService() {
        return new AuthService();
    }

    @Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver() {
        return new AuthenticationPrincipalArgumentResolver(authService());
    }
}
