package com.ftn.bsep.dto.user;

import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserDto {

    @NotNull
    @Size(max = 30)
    @Email
    @SafeHtml
    private @SQLInjectionSafe String email;

    @NotNull
    @Size(min = 15)
    @SafeHtml
    private @SQLInjectionSafe String password;

    @NotNull
    @Size(max = 20)
    @SafeHtml
    private @SQLInjectionSafe String name;

    @NotNull
    @Size(max = 20)
    @SafeHtml
    private @SQLInjectionSafe String lastName;

    public RegisterUserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
