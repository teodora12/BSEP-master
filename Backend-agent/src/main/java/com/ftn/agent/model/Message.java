
package com.ftn.agent.model;

import com.ftn.agent.dto.CreateMessageDTO;
import com.ftn.agent.model.forDatabase.MessageForDatabase;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DateOfSending" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/user}User"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/agent}Agent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "dateOfSending",
        "subject",
        "content",
        "user",
        "agent"
})
@XmlRootElement(name = "Message", namespace = "http://www.ftn.uns.ac.rs/message")
//@Table
//@Entity
public class Message {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/message")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "DateOfSending", namespace = "http://www.ftn.uns.ac.rs/message", required = true)
    protected Date dateOfSending;
    @XmlElement(name = "Subject", namespace = "http://www.ftn.uns.ac.rs/message", required = true)
    protected String subject;
    @XmlElement(name = "Content", namespace = "http://www.ftn.uns.ac.rs/message", required = true)
    protected String content;
    @XmlElement(name = "User", namespace = "http://www.ftn.uns.ac.rs/user", required = true)
    @ManyToOne
    protected User user;
    @XmlElement(name = "Agent", namespace = "http://www.ftn.uns.ac.rs/agent", required = true)
    @ManyToOne
    protected Agent agent;

    public Message(){}

    public Message(CreateMessageDTO messageDTO){
        this.content = messageDTO.getContent();
        this.subject = messageDTO.getSubject();

        Date today = new Date();
        this.dateOfSending = today;

//        try{
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.dateOfSending  =  dateFormat.parse(messageDTO.getDateOfSending());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

    }



    public Message(MessageForDatabase messageForDatabase){
        this.content = messageForDatabase.getContent();
        this.subject = messageForDatabase.getSubject();
        this.dateOfSending = messageForDatabase.getDateOfSending();
        this.user = messageForDatabase.getUser();

    }

    public Message(Message message){
        this.dateOfSending = message.getDateOfSending();
        this.subject = message.getSubject();
        this.content = message.getContent();
        this.user = message.getUser();

    }
    /**
     * Gets the value of the id property.
     *
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the dateOfSending property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Date getDateOfSending() {
        return dateOfSending;
    }

    /**
     * Sets the value of the dateOfSending property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDateOfSending(Date value) {
        this.dateOfSending = value;
    }

    /**
     * Gets the value of the subject property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the user property.
     *
     * @return
     *     possible object is
     *     {@link User }
     *
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     *
     * @param value
     *     allowed object is
     *     {@link User }
     *
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the agent property.
     *
     * @return
     *     possible object is
     *     {@link Agent }
     *
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     *
     * @param value
     *     allowed object is
     *     {@link Agent }
     *
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

}
