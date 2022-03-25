package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberRegisterForm {

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    @Min(value = 1, message = "나이는 1 이상 입력하세요.")
    @NotNull(message = "나이를 입력하세요.")
    private Integer age;

    @NotNull(message = "권한을 선택하세요.")
    private Role role;

    public Member toEntity() {
        return new Member(name, age, role);
    }
}
