package com.ftn.agent.dto;

import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegisterDTO {

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
       String email;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String name;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String surname;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String password;

    private AddressDTO addressDTO;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
