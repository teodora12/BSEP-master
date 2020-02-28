package com.ftn.agent.model.forDatabase;


import com.ftn.agent.dto.CreateMessageDTO;
import com.ftn.agent.model.Message;
import com.ftn.agent.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "message")
@Table(name = "message")
public class MessageForDatabase {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date dateOfSending;

    private String subject;

    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    private AgentForDatabase agent;

    public MessageForDatabase(){}

    public MessageForDatabase(Message message){
        this.dateOfSending = message.getDateOfSending();
        this.content = message.getContent();
        this.subject = message.getSubject();
    //    this.user = message.getUser();

    }


    public MessageForDatabase (CreateMessageDTO createMessageDTO){
        this.content = createMessageDTO.getContent();
        this.subject = createMessageDTO.getSubject();

        Date today = new Date();
        this.dateOfSending = today;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public AgentForDatabase getAgent() {
        return agent;
    }

    public void setAgent(AgentForDatabase agent) {
        this.agent = agent;
    }
}
