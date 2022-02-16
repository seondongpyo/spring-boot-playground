package io.github.seondongpyo.security.config.social;

import io.github.seondongpyo.security.domain.social.SocialUser;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(SocialUser user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
