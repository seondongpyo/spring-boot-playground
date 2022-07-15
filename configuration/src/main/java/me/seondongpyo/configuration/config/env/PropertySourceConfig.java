package me.seondongpyo.configuration.config.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertySourceConfig {

    private final Environment env;

    public PropertySourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public JwtTokenKeyProvider jwtTokenKeyProvider() {
        return new JwtTokenKeyProvider(env.getProperty("security-jwt-token-secret-key"));
    }
}
