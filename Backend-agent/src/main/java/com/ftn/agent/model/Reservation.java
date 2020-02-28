
package com.ftn.agent.model;

import com.ftn.agent.dto.CreateReservationDTO;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/user}User"/>
 *         &lt;element name="ArrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DepartureDate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Room" type="{http://www.ftn.uns.ac.rs/accommodation}TRoom" maxOccurs="unbounded"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AccommodationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NumberOfDaysForCancellation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PaidAdditionalServices" type="{http://www.ftn.uns.ac.rs/accommodation}TAdditionalService" maxOccurs="unbounded"/>
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
        "price",
        "user",
        "arrivalDate",
        "departureDate",
        "room",
        "status",
        "accommodationId",
        "numberOfDaysForCancellation",
        "paidAdditionalServices"
})
@XmlRootElement(name = "Reservation", namespace = "http://www.ftn.uns.ac.rs/accommodation")
@Table
@Entity
public class Reservation {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "Price", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected BigDecimal price;
    @XmlElement(name = "User", namespace = "http://www.ftn.uns.ac.rs/user", required = true)
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    protected User user;
    @XmlElement(name = "ArrivalDate", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected Date arrivalDate;
    @XmlElement(name = "DepartureDate", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected Date departureDate;
    @XmlElement(name = "Room", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @ManyToMany
    protected List<TRoom> room;
    @XmlElement(name = "Status", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String status;
     @XmlElement(name = "AccommodationId", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected long accommodationId;
    @XmlElement(name = "NumberOfDaysForCancellation", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected long numberOfDaysForCancellation;
    @XmlElement(name = "PaidAdditionalServices", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @ManyToMany
    protected List<TAdditionalService> paidAdditionalServices;


    public Reservation () {

    }

    public Reservation (CreateReservationDTO createReservationDTO){

       // format za postman 2019-04-01 14:45:00
//        try{
//             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.arrivalDate  =  dateFormat.parse(createReservationDTO.getStartDate());
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
//
//        try{
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.departureDate =  dateFormat.parse(createReservationDTO.getEndDate());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        this.price = BigDecimal.valueOf(0);

        this.arrivalDate = createReservationDTO.getStartDate();
        this.departureDate = createReservationDTO.getEndDate();
        double cena = 0;
        this.price = new BigDecimal(cena);

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
     * Gets the value of the price property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
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
     * Gets the value of the arrivalDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Date getArrivalDate() {
        return arrivalDate ;
    }



    /**
     * Sets the value of the arrivalDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setArrivalDate(Date value) {
        this.arrivalDate = value;
    }

    /**
     * Gets the value of the departureDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the value of the departureDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDepartureDate(Date value) {
        this.departureDate = value;
    }

    /**
     * Gets the value of the room property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRoom }
     *
     *
     */
    public List<TRoom> getRoom() {
        if (room == null) {
            room = new ArrayList<TRoom>();
        }
        return this.room;
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
     * Gets the value of the accommodationId property.
     *
     */
    public long getAccommodationId() {
        return accommodationId;
    }


    /**
     @Override
      * Sets the value of the accommodationId property.
      *
     */
    public void setAccommodationId(long value) {
        this.accommodationId = value;

    }
    /**
     * Gets the value of the numberOfDaysForCancellation property.
     *
     */
    public long getNumberOfDaysForCancellation() {
        return numberOfDaysForCancellation;
    }
    /**
     * Sets the value of the numberOfDaysForCancellation property.
     *
     */
    public void setNumberOfDaysForCancellation(long value) {
        this.numberOfDaysForCancellation = value;
    }
    /**
     * Gets the value of the paidAdditionalServices property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paidAdditionalServices property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaidAdditionalServices().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAdditionalService }
     *
     *
     */
    public List<TAdditionalService> getPaidAdditionalServices() {
        if (paidAdditionalServices == null) {
        paidAdditionalServices = new ArrayList<TAdditionalService>();
        }
        return this.paidAdditionalServices;
    }
}
