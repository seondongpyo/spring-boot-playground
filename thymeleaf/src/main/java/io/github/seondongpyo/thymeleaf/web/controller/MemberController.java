package io.github.seondongpyo.thymeleaf.web.controller;

import io.github.seondongpyo.thymeleaf.web.domain.Member;
import io.github.seondongpyo.thymeleaf.web.domain.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "modal-member";
    }

    @PostConstruct
    public void init() {
        memberService.save(new Member("memberA", 20));
        memberService.save(new Member("memberB", 30));
    }

}
