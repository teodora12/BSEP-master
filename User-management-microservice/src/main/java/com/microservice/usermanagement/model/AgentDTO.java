package com.microservice.usermanagement.model;

import lombok.Data;

@Data
public class AgentDTO {


    private String name;
    private String surname;
    private Address address;
    private int companyNumber;
    private  String username;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AgentDTO(String name, String surname, Address address, int companyNumber, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.companyNumber = companyNumber;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
