
package com.ftn.agent.model;

import com.ftn.agent.dto.ItemDTO;
import com.ftn.agent.dto.PricelistDTO;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for Pricelist complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Pricelist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Item" type="{http://www.ftn.uns.ac.rs/accommodation}Item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pricelist", namespace = "http://www.ftn.uns.ac.rs/accommodation", propOrder = {
        "id",
        "item"
})
@Entity
@Table
public class Pricelist {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "Item", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    protected List<Item> item;


    public Pricelist(){
        this.item = new ArrayList<>();
    }

    public Pricelist(PricelistDTO pricelistDTO){
        List<ItemDTO> itemDTOS = pricelistDTO.getItemDTOS();
        List<Item> items = new ArrayList<>();

        for (ItemDTO i: itemDTOS ){
            Item item = new Item(i);
            items.add(item);
        }

        this.item = items;
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
     * Gets the value of the item property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     *
     *
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }



}