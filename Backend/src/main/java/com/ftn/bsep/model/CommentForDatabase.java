package com.ftn.bsep.model;

import com.ftn.bsep.model.modelGenerated.TComment;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comment")
@Table(name = "comment")
@Data
public class CommentForDatabase {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private com.ftn.bsep.model.User user;

    @Column
    private String status;

    @Column
    private Date date;

    @Column
    private String content;

    public CommentForDatabase() {

    }

    public CommentForDatabase(TComment xmlComment, User user) {
        this.date = xmlComment.getDate();
        this.status = xmlComment.getStatus();
        this.user = user;
        this.content = xmlComment.getContent();

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
