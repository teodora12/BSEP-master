package com.ftn.bsep.model.modelGenerated;

import com.ftn.bsep.dto.accommodation.CreateAndUpdateAccDTO;
import com.ftn.bsep.dto.accommodation.ItemDTO;
import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.CommentForDatabase;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.stream.events.Comment;


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
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Room" type="{http://www.ftn.uns.ac.rs/accommodation}TRoom" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/address}Address"/>
 *         &lt;element name="AccommodationType" type="{http://www.ftn.uns.ac.rs/accommodation}TAccommodationType"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AccommodationCategory" type="{http://www.ftn.uns.ac.rs/accommodation}TAccommodationCategory"/>
 *         &lt;element name="Cancellation" type="{http://www.ftn.uns.ac.rs/accommodation}TCancellation"/>
 *         &lt;element name="Rate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Picture" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/agent}Agent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdditionalServiceWithPrices" type="{http://www.ftn.uns.ac.rs/accommodation}TAdditionalServicesWithPrices" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://www.ftn.uns.ac.rs/accommodation}TComment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Pricelist" type="{http://www.ftn.uns.ac.rs/accommodation}Pricelist"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NumberOfPeopleCapacity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
        "name",
        "room",
        "address",
        "accommodationType",
        "description",
        "accommodationCategory",
        "cancellation",
        "rate",
        "picture",
        "agent",
        "additionalServiceWithPrices",
        "comments",
        "pricelist",
        "capacity",
        "numberOfPeopleCapacity"
})
@XmlRootElement(name = "Accommodation", namespace = "http://www.ftn.uns.ac.rs/accommodation")
//@Table
//@Entity
public class Accommodation {

    @XmlElement(name = "Id", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @XmlElement(name = "Name", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String name;
    @XmlElement(name = "Room", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @OneToMany(fetch = FetchType.EAGER)
    protected List<TRoom> room;
    @XmlElement(name = "Address", namespace = "http://www.ftn.uns.ac.rs/address", required = true)
    @OneToOne
    protected Address address;
    @XmlElement(name = "AccommodationType", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @ManyToOne
    protected TAccommodationType accommodationType;
    @XmlElement(name = "Description", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    protected String description;
    @XmlElement(name = "AccommodationCategory", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @ManyToOne
    protected TAccommodationCategory accommodationCategory;
    @XmlElement(name = "Cancellation", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @OneToOne
    protected TCancellation cancellation;
    @XmlElement(name = "Rate", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected double rate;
    @XmlElement(name = "Picture", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="Pictures", joinColumns=@JoinColumn(name="accommodation_id"))
    @Column(name="picture")
    protected List<String> picture;
    @XmlElement(name = "Agent", namespace = "http://www.ftn.uns.ac.rs/agent")
    @ManyToMany
    protected List<Agent> agent;
    @XmlElement(name = "AdditionalServiceWithPrices", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<TAdditionalServicesWithPrices> additionalServiceWithPrices;
    @OneToMany
    @XmlElement(name = "Comments", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected List<TComment> comments;
    @XmlElement(name = "Pricelist", namespace = "http://www.ftn.uns.ac.rs/accommodation", required = true)
    @OneToOne
    protected Pricelist pricelist;
    @XmlElement(name = "Capacity", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected int capacity;
    @XmlElement(name = "NumberOfPeopleCapacity", namespace = "http://www.ftn.uns.ac.rs/accommodation")
    protected Integer numberOfPeopleCapacity;
    public Accommodation(){}



    public Accommodation (CreateAndUpdateAccDTO newAccommodationDTO) {

        this.name = newAccommodationDTO.getName();
        this.accommodationCategory = newAccommodationDTO.getCategory();
        this.accommodationType = newAccommodationDTO.getType();
        this.address = newAccommodationDTO.getAddress();
        this.agent = newAccommodationDTO.getAgents();
        this.description = newAccommodationDTO.getDescription();
        this.cancellation = newAccommodationDTO.getCancellation();
        this.picture = newAccommodationDTO.getPictures();
    //    this.additionalServiceWithPrices= newAccommodationDTO.getAdditionalServices();
        this.rate = 0;
        this.room = new ArrayList<TRoom>();
        this.comments = new ArrayList<>();
        this.capacity = newAccommodationDTO.getCapacity();
        this.numberOfPeopleCapacity = 0;

        List<Item> items = new ArrayList<>();
        List<ItemDTO> itemDTOS = newAccommodationDTO.getPricelist().getItemDTOS();

        for(ItemDTO pld : itemDTOS){
            Item item = new Item(pld);
            items.add(item);
        }

        Pricelist pricelist = new Pricelist();
        pricelist.getItem().addAll(items);
        this.pricelist = pricelist;

    }

    public Accommodation (AccommodationForDatabase accommodationForDatabase){

          this.name = accommodationForDatabase.getName();
          this.description = accommodationForDatabase.getDescription();
          this.capacity = accommodationForDatabase.getCapacity();
          this.address = accommodationForDatabase.getAddress();
          this.cancellation = accommodationForDatabase.getCancellation();
          this.agent = accommodationForDatabase.getAgent();
          this.additionalServiceWithPrices = accommodationForDatabase.getAdditionalServicesWithPrices();
          this.pricelist = accommodationForDatabase.getPricelist();
          this.picture = accommodationForDatabase.getPicture();
          this.room  = accommodationForDatabase.getRoom();
          this.accommodationCategory = accommodationForDatabase.getAccommodationCategory();
          this.rate = accommodationForDatabase.getRate();
          this.accommodationType = accommodationForDatabase.getAccommodationType();
          this.numberOfPeopleCapacity = accommodationForDatabase.getNumberOfPeopleCapacity();

          List<TComment> comments = new ArrayList<>();
          for(CommentForDatabase commentForDatabase: accommodationForDatabase.getComments()){

             TComment comment = new TComment(commentForDatabase);
             comments.add(comment);

          }
          this.comments = comments;


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
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link Address }
     *
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link Address }
     *
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the accommodationType property.
     *
     * @return
     *     possible object is
     *     {@link TAccommodationType }
     *
     */
    public TAccommodationType getAccommodationType() {
        return accommodationType;
    }

    /**
     * Sets the value of the accommodationType property.
     *
     * @param value
     *     allowed object is
     *     {@link TAccommodationType }
     *
     */
    public void setAccommodationType(TAccommodationType value) {
        this.accommodationType = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the accommodationCategory property.
     *
     * @return
     *     possible object is
     *     {@link TAccommodationCategory }
     *
     */
    public TAccommodationCategory getAccommodationCategory() {
        return accommodationCategory;
    }

    /**
     * Sets the value of the accommodationCategory property.
     *
     * @param value
     *     allowed object is
     *     {@link TAccommodationCategory }
     *
     */
    public void setAccommodationCategory(TAccommodationCategory value) {
        this.accommodationCategory = value;
    }

    /**
     * Gets the value of the cancellation property.
     *
     * @return
     *     possible object is
     *     {@link TCancellation }
     *
     */
    public TCancellation getCancellation() {
        return cancellation;
    }

    /**
     * Sets the value of the cancellation property.
     *
     * @param value
     *     allowed object is
     *     {@link TCancellation }
     *
     */
    public void setCancellation(TCancellation value) {
        this.cancellation = value;
    }

    /**
     * Gets the value of the rate property.
     *
     */
    public double getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     *
     */
    public void setRate(double value) {
        this.rate = value;
    }

    /**
     * Gets the value of the picture property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the picture property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPicture().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getPicture() {
        if (picture == null) {
            picture = new ArrayList<String>();
        }
        return this.picture;
    }



    /**
     * Gets the value of the additionalServiceWithPrices property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalServiceWithPrices property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalServiceWithPrices().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TAdditionalServicesWithPrices }
     *
     *
     */
    public List<TAdditionalServicesWithPrices> getAdditionalServiceWithPrices() {
        if (additionalServiceWithPrices == null) {
            additionalServiceWithPrices = new ArrayList<TAdditionalServicesWithPrices>();
        }
        return this.additionalServiceWithPrices;
    }

    /**
     * Gets the value of the comments property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TComment }
     *
     *
     */
    public List<TComment> getComments() {
        if (comments == null) {
            comments = new ArrayList<TComment>();
        }
        return this.comments;
    }
    /**
     * Gets the value of the agent property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agent property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Agent }
     *
     *
     */
    public List<Agent> getAgent() {
        if (agent == null) {
            agent = new ArrayList<Agent>();
        }
        return this.agent;
    }


    /**
     * Gets the value of the pricelist property.
     *
     * @return
     *     possible object is
     *     {@link Pricelist }
     *
     */
    public Pricelist getPricelist() {
        return pricelist;
    }

    /**
     * Sets the value of the pricelist property.
     *
     * @param value
     *     allowed object is
     *     {@link Pricelist }
     *
     */
    public void setPricelist(Pricelist value) {
        this.pricelist = value;
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

    /**
     * Gets the value of the numberOfPeopleCapacity property.
     *
     */
    public int getNumberOfPeopleCapacity() {
        return numberOfPeopleCapacity;
    }

    /**
     * Sets the value of the numberOfPeopleCapacity property.
     *
     */
    public void setNumberOfPeopleCapacity(Integer value) {
        this.numberOfPeopleCapacity = value;
    }
}
