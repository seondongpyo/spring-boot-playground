package io.github.seondongpyo.security.config;

import io.github.seondongpyo.security.config.social.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.github.seondongpyo.security.domain.Role;
import io.github.seondongpyo.security.domain.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final CustomAuthenticationProvider authenticationProvider;
	private final UserService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());

		auth
			.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
				.disable()
			.headers()
				.frameOptions()
					.disable();

		http.authorizeRequests()
				.antMatchers("/login")
					.permitAll()
				.antMatchers("/user")
					.hasAuthority(Role.USER.name())
				.antMatchers("/admin")
					.hasAnyAuthority(Role.ADMIN.name());

		http.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/");

		http.oauth2Login()
				.userInfoEndpoint()
				.userService(customOAuth2UserService);
	}
}
