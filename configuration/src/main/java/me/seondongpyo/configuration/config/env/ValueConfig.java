package me.seondongpyo.configuration.config.env;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "me.seondongpyo.configuration.config.env")
public class ValueConfig {
}
