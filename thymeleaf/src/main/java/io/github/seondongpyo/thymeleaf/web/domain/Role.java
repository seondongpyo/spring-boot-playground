package io.github.seondongpyo.thymeleaf.web.domain;

import lombok.Getter;

@Getter
public enum Role {
    ALL,
    MEMBER,
    MANAGER,
    ADMIN;

    public boolean isAll() {
        return this == ALL;
    }
}
