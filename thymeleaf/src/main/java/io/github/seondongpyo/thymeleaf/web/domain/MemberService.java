package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findAllByRole(Optional<Role> role) {
        if (role.isEmpty()) {
            return memberRepository.findAll();
        }
        return memberRepository.findAllByRole(role.get());
    }

    public void approve(Long memberId, String approvalCommand) {
        memberRepository.findById(memberId)
            .ifPresent(member -> {
                if (approvalCommand.equals("approve")) {
                    member.approve();
                    return;
                }
                member.disapprove();
            });
    }
}
