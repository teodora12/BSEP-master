
package com.ftn.bsep.model.modelGenerated;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TRoom complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TRoom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Capacity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Floor" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="RoomNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "TRoom", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
        "capacity",
        "floor",
        "roomNumber",
        "id",
        "accommodationName"
})
@Table
@Entity
public class TRoom {

    @XmlElement(name = "Capacity", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger capacity;
    @XmlElement(name = "Floor", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger floor;
    @XmlElement(name = "RoomNumber", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger roomNumber;
    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "AccommodationName", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String accommodationName;

    public TRoom (){}



    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCapacity(BigInteger value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the floor property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFloor(BigInteger value) {
        this.floor = value;
    }

    /**
     * Gets the value of the roomNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of the roomNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRoomNumber(BigInteger value) {
        this.roomNumber = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TRoom room = (TRoom) o;
        return id == room.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
