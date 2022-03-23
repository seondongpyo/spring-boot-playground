package io.github.seondongpyo.thymeleaf.web.controller;

import io.github.seondongpyo.thymeleaf.web.domain.Member;
import io.github.seondongpyo.thymeleaf.web.domain.MemberRegisterForm;
import io.github.seondongpyo.thymeleaf.web.domain.MemberService;
import io.github.seondongpyo.thymeleaf.web.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @ModelAttribute("roles")
    public List<Role> roles() {
        return Arrays.stream(Role.values())
            .collect(Collectors.toList());
    }

    @GetMapping("/members")
    public String members(@RequestParam(required = false) Role role,
                          Model model) {
        List<Member> members = memberService.findAllByRole(role);
        model.addAttribute("members", members);
        return "table-members";
    }

    @PostMapping("/members/{memberId}/{approvalCommand}")
    @ResponseBody
    public String approve(@PathVariable Long memberId,
                          @PathVariable String approvalCommand) {
        memberService.approve(memberId, approvalCommand);
        return "success";
    }

    @GetMapping("/members/register")
    public String register(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/members/register")
    public String register(@ModelAttribute MemberRegisterForm form) {
        Member member = form.toEntity();
        memberService.save(member);
        return "redirect:/";
    }

    @PostConstruct
    public void init() {
        memberService.save(new Member("admin", 40, Role.ADMIN));
        memberService.save(new Member("manager", 30, Role.MANAGER));
        memberService.save(new Member("member", 20, Role.MEMBER));
    }

}
