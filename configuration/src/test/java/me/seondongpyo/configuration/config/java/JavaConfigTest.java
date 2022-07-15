package me.seondongpyo.configuration.config.java;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class JavaConfigTest {

    @Test
    void javaConfig() {
        AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(AuthenticationPrincipalConfig.class);

        AuthService authService = applicationContext.getBean(AuthService.class);
        AuthenticationPrincipalArgumentResolver argumentResolver
            = applicationContext.getBean(AuthenticationPrincipalArgumentResolver.class);

        assertThat(argumentResolver.getAuthService()).isEqualTo(authService);
    }
}
