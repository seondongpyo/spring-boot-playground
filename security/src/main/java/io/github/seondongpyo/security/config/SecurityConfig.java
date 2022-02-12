package io.github.seondongpyo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
			.headers()
				.frameOptions()
				.disable()
			.and()
				.authorizeRequests()
				.antMatchers("/", "/login")
					.permitAll()
				.anyRequest()
					.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error=true");
	}
}
