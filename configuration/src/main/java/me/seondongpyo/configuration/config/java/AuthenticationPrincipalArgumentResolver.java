package me.seondongpyo.configuration.config.java;

public class AuthenticationPrincipalArgumentResolver {

    private final AuthService authService;

    public AuthenticationPrincipalArgumentResolver(AuthService authService) {
        this.authService = authService;
    }

    public String getName() {
        return authService.getName();
    }

    public AuthService getAuthService() {
        return authService;
    }
}
