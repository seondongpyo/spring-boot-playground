package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegisterForm {

    private String name;
    private Integer age;
    private Role role;

    public Member toEntity() {
        return new Member(name, age, role);
    }
}
