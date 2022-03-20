package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllByRole(Role role) {
        return role.isAll() ? memberRepository.findAll()
                            : memberRepository.findAllByRole(role);
    }
}
