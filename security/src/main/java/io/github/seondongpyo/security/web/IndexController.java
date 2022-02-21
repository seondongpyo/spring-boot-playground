package io.github.seondongpyo.security.web;

import io.github.seondongpyo.security.config.social.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final HttpSession httpSession;

	@GetMapping("/")
	public String index(Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if (user != null) {
			model.addAttribute("username", user.getName());
		}
		return "index";
	}

	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "If you can see this message, your role is User";
	}

	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "If you can see this message, your role is Admin";
	}
}
