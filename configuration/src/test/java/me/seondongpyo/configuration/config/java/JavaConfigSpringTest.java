package me.seondongpyo.configuration.config.java;

import me.seondongpyo.configuration.ConfigurationApplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class JavaConfigSpringTest {

    @Autowired
    private AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver;

    @Test
    void javaConfig() {
        assertThat(authenticationPrincipalArgumentResolver.getName()).isEqualTo("USER");
    }

    @Test
    void useSpringBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApplication.class);
        AuthService authService = context.getBean(AuthService.class);
        AuthenticationPrincipalArgumentResolver argumentResolver = context.getBean(AuthenticationPrincipalArgumentResolver.class);
        assertThat(authService).isEqualTo(argumentResolver.getAuthService());
    }
}
