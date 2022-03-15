package io.github.seondongpyo.security.config;

import io.github.seondongpyo.security.config.social.CustomOAuth2UserService;
import io.github.seondongpyo.security.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final CustomAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
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

//		http.oauth2Login()
//				.userInfoEndpoint()
//				.userService(customOAuth2UserService);
	}
}
