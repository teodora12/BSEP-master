package com.ftn.bsep.dto.message;

import com.ftn.bsep.model.MessageForDatabase;
import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
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
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String dateOfSending;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String agentUsername;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String userUsername;

    public CreateMessageDTO() {

    }

    public CreateMessageDTO(String subject, String content, String dateOfSending, String agentUsername, String userUsername) {
        this.subject = subject;
        this.content = content;
        this.dateOfSending = dateOfSending;
        this.agentUsername = agentUsername;
        this.userUsername = userUsername;
    }

    public CreateMessageDTO(MessageForDatabase messageForDatabase){
        this.subject = messageForDatabase.getSubject();
        this.content = messageForDatabase.getContent();

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

    public String getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(String dateOfSending) {
        this.dateOfSending = dateOfSending;
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

