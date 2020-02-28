
package com.ftn.bsep.model.modelGenerated;

import com.ftn.bsep.model.CommentForDatabase;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;


/**
 * <p>Java class for TComment complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TComment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/user}User"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TComment", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
    "id",
    "user",
    "status",
    "date",
    "content"
})

public class TComment {

//    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
//    @Id
//    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "User", namespace = "http://www.ftn.uns.ac.rs/user", required = true)
  //  @OneToOne
    protected com.ftn.bsep.model.modelGenerated.User user;
    @XmlElement(name = "Status", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String status;
    @XmlElement(name = "Date", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date date;
    @XmlElement(name = "Content", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String content;




    public TComment (){}

    public TComment(CommentForDatabase commentForDatabase)
    {
        this.status = commentForDatabase.getStatus();
        this.date = commentForDatabase.getDate();
        com.ftn.bsep.model.User userDataBase = commentForDatabase.getUser();

        com.ftn.bsep.model.modelGenerated.User user = new User(userDataBase);
        this.user = user;
        this.content = commentForDatabase.getContent();
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
        this.date = value;
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
}
