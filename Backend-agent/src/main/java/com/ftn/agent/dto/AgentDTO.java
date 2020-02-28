package com.ftn.agent.dto;

import com.ftn.agent.model.forDatabase.AgentForDatabase;

public class AgentDTO {

    private String name;

    private String surname;

    private int companyNumber;

    private String username;

    private String email;


    public AgentDTO() {}

    public AgentDTO(AgentForDatabase agentForDatabase) {
        this.companyNumber = agentForDatabase.getCompanyNumber();
        this.name = agentForDatabase.getName();
        this.surname = agentForDatabase.getSurname();
        this.email = agentForDatabase.getEmail();
        this.username = agentForDatabase.getUsername();


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

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
