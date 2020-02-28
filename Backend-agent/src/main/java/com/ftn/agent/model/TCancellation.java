
package com.ftn.agent.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TCancellation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TCancellation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Days" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TCancellation", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
        "isEnabled",
        "days",
        "id"
})
@Entity
@Table
public class TCancellation {

    @XmlElement(name = "IsEnabled", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected boolean isEnabled;
    @XmlElement(name = "Days", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected int days;
    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    /**
     * Gets the value of the isEnabled property.
     *
     */

    public TCancellation() {}

    public TCancellation(TCancellation cancellation){
        this.isEnabled = cancellation.isIsEnabled();
        this.days = cancellation.getDays();

    }

    public boolean isIsEnabled() {
        return isEnabled;
    }

    /**
     * Sets the value of the isEnabled property.
     *
     */
    public void setIsEnabled(boolean value) {
        this.isEnabled = value;
    }

    /**
     * Gets the value of the days property.
     *
     */
    public int getDays() {
        return days;
    }

    /**
     * Sets the value of the days property.
     *
     */
    public void setDays(int value) {
        this.days = value;
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

}
