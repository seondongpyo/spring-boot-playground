package me.seondongpyo.configuration.config.env;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class EnvironmentTest {

    @Test
    void key() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        JwtTokenKeyProvider jwtTokenKeyProvider = context.getBean(JwtTokenKeyProvider.class);
        assertThat(jwtTokenKeyProvider.getSecretKey()).isEqualTo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIiLCJuYW1lIjoiSm9obiBEb2UiLCJpYXQiOjE1MTYyMzkwMjJ9.ih1aovtQShabQ7l0cINw4k1fagApg3qLWiB8Kt59Lno");
    }

    @Test
    void expire() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValueConfig.class);
        JwtTokenExpireProvider jwtTokenExpireProvider = context.getBean(JwtTokenExpireProvider.class);
        assertThat(jwtTokenExpireProvider.getValidityInMilliseconds()).isEqualTo(3600000);
    }
}
