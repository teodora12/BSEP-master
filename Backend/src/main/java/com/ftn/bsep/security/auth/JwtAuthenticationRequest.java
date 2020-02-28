package com.ftn.bsep.security.auth;


import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotNull;

public class JwtAuthenticationRequest {

    @NotNull
    @SafeHtml
    private @SQLInjectionSafe String username;

    @NotNull
    @SafeHtml
    private @SQLInjectionSafe String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
