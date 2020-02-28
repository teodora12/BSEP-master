
package com.ftn.agent.model;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


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
 *         &lt;element name="Room" type="{http://www.ftn.uns.ac.rs/accommodation}TRoom"/>
 *         &lt;element name="AccommodationName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OldRoomNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
    "room",
    "accommodationName",
    "oldRoomNumber"
})
@XmlRootElement(name = "UpdateRoomRequest", namespace = "http://www.ftn.uns.ac.rs/accommodation")
public class UpdateRoomRequest {

    @XmlElement(name = "Room", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected TRoom room;
    @XmlElement(name = "AccommodationName", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String accommodationName;
    @XmlElement(name = "OldRoomNumber", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger oldRoomNumber;

    /**
     * Gets the value of the room property.
     * 
     * @return
     *     possible object is
     *     {@link TRoom }
     *     
     */
    public TRoom getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRoom }
     *     
     */
    public void setRoom(TRoom value) {
        this.room = value;
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

    /**
     * Gets the value of the oldRoomNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOldRoomNumber() {
        return oldRoomNumber;
    }

    /**
     * Sets the value of the oldRoomNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOldRoomNumber(BigInteger value) {
        this.oldRoomNumber = value;
    }

}
