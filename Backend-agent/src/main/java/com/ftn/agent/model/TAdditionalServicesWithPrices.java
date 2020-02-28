
package com.ftn.agent.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;


/**
 * <p>Java class for TAdditionalServicesWithPrices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAdditionalServicesWithPrices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalServices" type="{http://www.ftn.uns.ac.rs/accommodation}TAdditionalService"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAdditionalServicesWithPrices", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
    "additionalServices",
    "price",
    "id"
})

@Entity
@Table
public class TAdditionalServicesWithPrices {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "AdditionalServices", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @OneToOne
    protected TAdditionalService additionalServices;
    @XmlElement(name = "Price", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected double price;

    /**
     * Gets the value of the additionalServices property.
     * 
     * @return
     *     possible object is
     *     {@link TAdditionalService }
     *     
     */


    public TAdditionalServicesWithPrices (TAdditionalService tAdditionalService){

        this.additionalServices = tAdditionalService;
        this.price = 0;

    }

    public TAdditionalServicesWithPrices() {}
    public TAdditionalService getAdditionalServices() {
        return additionalServices;
    }

    /**
     * Sets the value of the additionalServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAdditionalService }
     *     
     */
    public void setAdditionalServices(TAdditionalService value) {
        this.additionalServices = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAdditionalServicesWithPrices that = (TAdditionalServicesWithPrices) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
