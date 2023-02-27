package com.shah.starter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    private final String loginEndpoint;
    private final String jwtKey;
    private final String jwtHeader;
    private final String allowedOrigins;
    private final String jwtIssuer;
    private final String jwtSubject;

    @Autowired
    public AppConfig(@Value("${ss.jwt.login.endpoint}") String endpoint,
                     @Value("${ss.jwt.key}") String jwtKey,
                     @Value("${ss.jwt.header}") String jwtHeader,
                     @Value("${ss.jwt.issuer}") String issuer,
                     @Value("${ss.jwt.subject}") String subject,
                     @Value("${ss.general.allowedOrigins}") String allowedOrigins) {

        this.loginEndpoint = endpoint;
        this.jwtHeader = jwtHeader;
        this.jwtKey = jwtKey;
        this.allowedOrigins = allowedOrigins;
        this.jwtIssuer = issuer;
        this.jwtSubject = subject;
    }


    public String getLoginEndpoint() {
        return loginEndpoint;
    }

    public String getJwtKey() {
        return jwtKey;
    }

    public String getJwtHeader() {
        return jwtHeader;
    }

    public String getAllowedOrigins() {
        return allowedOrigins;
    }

    public String getJwtIssuer() {
        return jwtIssuer;
    }

    public String getJwtSubject() {
        return jwtSubject;
    }
}
