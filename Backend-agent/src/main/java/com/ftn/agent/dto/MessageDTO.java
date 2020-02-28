package com.ftn.agent.dto;

import com.ftn.agent.model.Address;
import com.ftn.agent.model.User;
import com.ftn.agent.model.forDatabase.MessageForDatabase;


import java.util.Date;

public class MessageDTO {

    private Date dateOfSending;

    private String subject;

    private String content;


    private User user;


    private AgentDTO agent;

    public MessageDTO(){}


    public MessageDTO(MessageForDatabase messageForDatabase){
        this.dateOfSending = messageForDatabase.getDateOfSending();
        this.subject = messageForDatabase.getSubject();
        this.content = messageForDatabase.getContent();
        this.user = messageForDatabase.getUser();
        this.agent = new AgentDTO(messageForDatabase.getAgent());
    }

    public Date getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(Date dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AgentDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentDTO agent) {
        this.agent = agent;
    }
}
