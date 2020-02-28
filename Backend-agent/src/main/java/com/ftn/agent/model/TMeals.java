
package com.ftn.agent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TMeals complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TMeals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Breakfast" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HalfBoard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AllInclusive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FullBoard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMeals", namespace = "http://www.ftn.uns.ac.rs/accomodation", propOrder = {
    "breakfast",
    "halfBoard",
    "allInclusive",
    "fullBoard"
})
public class TMeals {

    @XmlElement(name = "Breakfast", namespace = "http://www.ftn.uns.ac.rs/accomodation")
    protected boolean breakfast;
    @XmlElement(name = "HalfBoard", namespace = "http://www.ftn.uns.ac.rs/accomodation")
    protected boolean halfBoard;
    @XmlElement(name = "AllInclusive", namespace = "http://www.ftn.uns.ac.rs/accomodation")
    protected boolean allInclusive;
    @XmlElement(name = "FullBoard", namespace = "http://www.ftn.uns.ac.rs/accomodation")
    protected boolean fullBoard;

    /**
     * Gets the value of the breakfast property.
     * 
     */
    public boolean isBreakfast() {
        return breakfast;
    }

    /**
     * Sets the value of the breakfast property.
     * 
     */
    public void setBreakfast(boolean value) {
        this.breakfast = value;
    }

    /**
     * Gets the value of the halfBoard property.
     * 
     */
    public boolean isHalfBoard() {
        return halfBoard;
    }

    /**
     * Sets the value of the halfBoard property.
     * 
     */
    public void setHalfBoard(boolean value) {
        this.halfBoard = value;
    }

    /**
     * Gets the value of the allInclusive property.
     * 
     */
    public boolean isAllInclusive() {
        return allInclusive;
    }

    /**
     * Sets the value of the allInclusive property.
     * 
     */
    public void setAllInclusive(boolean value) {
        this.allInclusive = value;
    }

    /**
     * Gets the value of the fullBoard property.
     * 
     */
    public boolean isFullBoard() {
        return fullBoard;
    }

    /**
     * Sets the value of the fullBoard property.
     * 
     */
    public void setFullBoard(boolean value) {
        this.fullBoard = value;
    }

}
