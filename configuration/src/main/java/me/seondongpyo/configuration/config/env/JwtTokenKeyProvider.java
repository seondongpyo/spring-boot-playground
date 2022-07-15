package me.seondongpyo.configuration.config.env;

public class JwtTokenKeyProvider {

    private String secretKey;

    public JwtTokenKeyProvider(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
