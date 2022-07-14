package me.seondongpyo.configuration.config.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class XMLConfigTest {

    @Test
    void xmlConfig() {
        ClassPathXmlApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("application-context.xml");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        assertThat(beanDefinitionNames).containsExactly("userRepository", "userService");

        UserService userService = applicationContext.getBean(UserService.class);
        List<User> users = userService.findAll();
        assertThat(users).hasSize(2);
    }
}
