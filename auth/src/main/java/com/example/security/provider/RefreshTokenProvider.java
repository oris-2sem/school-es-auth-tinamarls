package com.example.security.provider;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.security.auth.RefreshTokenAuthentication;
import com.example.security.exception.RefreshTokenException;
import com.example.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class RefreshTokenProvider implements AuthenticationProvider {

    private final JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String refreshTokenValue = (String) authentication.getCredentials();
        try {
            return jwtUtil.buildAuthentication(refreshTokenValue);
        } catch (JWTVerificationException e) {
            log.info(e.getMessage());
            throw new RefreshTokenException(e.getMessage(), e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return RefreshTokenAuthentication.class.isAssignableFrom(authentication);
    }
}
