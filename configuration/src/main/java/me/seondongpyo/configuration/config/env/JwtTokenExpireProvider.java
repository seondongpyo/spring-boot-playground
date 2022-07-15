package me.seondongpyo.configuration.config.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenExpireProvider {

    private final long validityInMilliseconds;

    public JwtTokenExpireProvider(@Value("${security-jwt-token-expire-length}") long validityInMilliseconds) {
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }
}
