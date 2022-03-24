package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberRegisterForm {

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    @NotBlank(message = "나이를 입력하세요.")
    private Integer age;

    @NotBlank(message = "권한을 선택하세요.")
    private Role role;

    public Member toEntity() {
        return new Member(name, age, role);
    }
}
