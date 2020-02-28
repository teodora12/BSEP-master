package com.ftn.agent.dto;

import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateMessageDTO {

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String subject;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String content;


    @NotNull
    @NotBlank
    @SafeHtml
    private @SQLInjectionSafe String agentUsername;

    @NotNull
    @NotBlank
    @SafeHtml
    private @SQLInjectionSafe String userUsername;

    public CreateMessageDTO(){}



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

    public String getAgentUsername() {
        return agentUsername;
    }

    public void setAgentUsername(String agentUsername) {
        this.agentUsername = agentUsername;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
