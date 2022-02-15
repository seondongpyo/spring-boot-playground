package io.github.seondongpyo.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityLoginTest {

	@Autowired
	MockMvc mvc;

	@DisplayName("로그인 성공")
	@Test
	void loginSuccess() throws Exception {
		mvc.perform(formLogin().user("user1").password("user1"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/"));
	}
	
	@DisplayName("로그인 실패")
	@Test
	void loginFailure() throws Exception {
		mvc.perform(formLogin().user("user1").password("user2"))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/login?error"));
	}

	@DisplayName("사용자 권한 제한이 'USER' 인 페이지로 이동 - USER 권한")
	@WithMockUser(authorities = "USER")
	@Test
	void userSuccess() throws Exception {
		mvc.perform(get("/user"))
			.andExpect(status().isOk())
			.andExpect(content().string("If you can see this message, your role is User"));
	}

	@DisplayName("사용자 권한 제한이 'USER' 인 페이지로 이동 - ADMIN 권한")
	@WithMockUser(authorities = "ADMIN")
	@Test
	void userFailure() throws Exception {
		mvc.perform(get("/user"))
			.andExpect(status().isForbidden());
	}

	@DisplayName("사용자 권한 제한이 'USER' 인 페이지로 이동 - ADMIN 권한")
	@WithMockUser(authorities = "ADMIN")
	@Test
	void adminSuccess() throws Exception {
		mvc.perform(get("/admin"))
			.andExpect(status().isOk())
			.andExpect(content().string("If you can see this message, your role is Admin"));
	}

	@DisplayName("사용자 권한 제한이 'ADMIN' 인 페이지로 이동 - USER 권한")
	@WithMockUser(authorities = "USER")
	@Test
	void adminFailure() throws Exception {
		mvc.perform(get("/admin"))
			.andExpect(status().isForbidden());
	}
}
