
package com.ftn.agent.model;


import com.ftn.agent.dto.ItemDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <p>Java class for Item complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startDatePeriod" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="endDatePeriod" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
        "id",
        "startDatePeriod",
        "endDatePeriod",
        "price",
        "capacity"
})
@Entity
@Table
public class Item {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date startDatePeriod;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date endDatePeriod;
    @XmlElement(name = "Price", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected double price;
    @XmlElement(name = "Capacity", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected int capacity;



    public Item() {}

    public Item(Item item){
        this.endDatePeriod = item.getEndDatePeriod();
        this.startDatePeriod = item.getStartDatePeriod();
        this.price= item.getPrice();
        this.capacity = item.getCapacity();
    }

    public Item (ItemDTO itemDTO){
        this.capacity = itemDTO.getCapacity();
        this.price = itemDTO.getPrice();

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.startDatePeriod  =  dateFormat.parse(itemDTO.getStartPeriodDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.endDatePeriod =  dateFormat.parse(itemDTO.getEndPeriodDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }





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
     * Gets the value of the startDatePeriod property.
     *
     * @return
     *     possible object is
     *     {@link Date }
     *
     */
    public Date getStartDatePeriod() {
        return startDatePeriod;
    }

    /**
     * Sets the value of the startDatePeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link Date }
     *
     */
    public void setStartDatePeriod(Date value) {
        this.startDatePeriod = value;
    }

    /**
     * Gets the value of the endDatePeriod property.
     *
     * @return
     *     possible object is
     *     {@link Date }
     *
     */
    public Date getEndDatePeriod() {
        return endDatePeriod;
    }

    /**
     * Sets the value of the endDatePeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link Date }
     *
     */
    public void setEndDatePeriod(Date value) {
        this.endDatePeriod = value;
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

    /**
     * Gets the value of the capacity property.
     *
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     *
     */
    public void setCapacity(int value) {
        this.capacity = value;
    }








//    public Pricelist(PricelistDTO pricelistDTO){
//        this.capacity = pricelistDTO.getCapacity();
//        this.price = pricelistDTO.getPrice();
//
//        try{
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.startDatePeriod  =  dateFormat.parse(pricelistDTO.getStartPeriod());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        try{
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            this.endDatePeriod =  dateFormat.parse(pricelistDTO.getEndPerid());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
