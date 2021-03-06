package io.github.seondongpyo.security.config;

import io.github.seondongpyo.security.config.social.CustomOAuth2UserService;
import io.github.seondongpyo.security.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final CustomAuthenticationProvider authenticationProvider;
	private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;

	@Bean
	public SecurityContextLogoutHandler securityContextLogoutHandler() {
		return new SecurityContextLogoutHandler();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 해당 설정 추가 시, 정적 리소스들은 보안 필터를 거치지 않는다.
		web
			.ignoring()
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf()
//				.disable();

		http.headers()
				.frameOptions()
					.disable();

		http.authorizeRequests()
				.antMatchers("/login", "/logout")
					.permitAll()
				.antMatchers("/user")
					.hasAuthority(Role.USER.name())
				.antMatchers("/admin")
					.hasAuthority(Role.ADMIN.name())
				.anyRequest()
					.authenticated();

		http.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.successHandler(authenticationSuccessHandler)
				.permitAll();

//		http.oauth2Login()
//				.userInfoEndpoint()
//				.userService(customOAuth2UserService);
	}
}
