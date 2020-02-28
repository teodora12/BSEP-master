package com.ftn.bsep.dto.keystore;

import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

public class NewKeystoreDto {

    @SafeHtml
    private @SQLInjectionSafe String name;
    private @SQLInjectionSafe String password;

    public NewKeystoreDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
