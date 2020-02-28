
package com.ftn.agent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/accommodation}Reservation"/>
 *         &lt;element name="AccommodationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "reservation",
        "accommodationName"
})
@XmlRootElement(name = "ReserveRoomRequest", namespace = "http://www.ftn.uns.ac.rs/accommodation")
public class ReserveRoomRequest {

    @XmlElement(name = "Reservation", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected Reservation reservation;
    @XmlElement(name = "AccommodationName", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String accommodationName;

    /**
     * Gets the value of the reservation property.
     *
     * @return
     *     possible object is
     *     {@link Reservation }
     *
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Sets the value of the reservation property.
     *
     * @param value
     *     allowed object is
     *     {@link Reservation }
     *
     */
    public void setReservation(Reservation value) {
        this.reservation = value;
    }

    /**
     * Gets the value of the accommodationName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccommodationName() {
        return accommodationName;
    }

    /**
     * Sets the value of the accommodationName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccommodationName(String value) {
        this.accommodationName = value;
    }

}
