package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean approved;

    public Member(String name, Integer age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    public void disapprove() {
        this.approved = false;
    }
}
