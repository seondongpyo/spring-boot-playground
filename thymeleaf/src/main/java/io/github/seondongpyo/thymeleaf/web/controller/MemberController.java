package io.github.seondongpyo.thymeleaf.web.controller;

import io.github.seondongpyo.thymeleaf.web.domain.Member;
import io.github.seondongpyo.thymeleaf.web.domain.MemberService;
import io.github.seondongpyo.thymeleaf.web.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findAll();
        List<Role> roles = Arrays.stream(Role.values())
            .collect(Collectors.toList());

        model.addAttribute("members", members);
        model.addAttribute("roles", roles);
        return "modal-member";
    }

    @PostConstruct
    public void init() {
        memberService.save(new Member("admin", 40, Role.ADMIN));
        memberService.save(new Member("manager", 30, Role.MANAGER));
        memberService.save(new Member("member", 20, Role.MEMBER));
    }

}
