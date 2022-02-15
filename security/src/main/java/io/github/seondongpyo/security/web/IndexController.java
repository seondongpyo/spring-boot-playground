package io.github.seondongpyo.security.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping("/user")
	public String user() {
		return "If you can see this message, your role is User";
	}

	@GetMapping("/admin")
	public String admin() {
		return "If you can see this message, your role is Admin";
	}
}
