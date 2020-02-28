package com.ftn.bsep.dto.user;

import com.ftn.bsep.model.User;
import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * User with name, last name, email and id
 * */
public class BasicUserDto {

    private Long id;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String email;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String name;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String lastName;

    public BasicUserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.lastName = user.getLastName();
    }

    public BasicUserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
