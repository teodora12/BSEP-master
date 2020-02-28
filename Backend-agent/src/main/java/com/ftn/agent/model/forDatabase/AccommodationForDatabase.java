package com.ftn.agent.model.forDatabase;


import com.ftn.agent.model.*;
import com.ftn.agent.restService.AdditionalServicePriceService;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "accommodation")
@Table(name = "accommodation")
public class AccommodationForDatabase {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany (cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TRoom> room;
    @OneToOne
    private Address address;
    @ManyToOne
    private TAccommodationType accommodationType;
    private String description;
    @ManyToOne
    private TAccommodationCategory accommodationCategory;
    @OneToOne
    private TCancellation cancellation;
    private double rate;
    @ElementCollection(fetch = FetchType.EAGER)
    //  @LazyCollection(LazyCollectionOption.FALSE)
    @CollectionTable(name="Pictures", joinColumns=@JoinColumn(name="accommodation_id"))
    @Column(name="picture")
    private List<String> picture;
    @ManyToMany
    private List<AgentForDatabase> agent;
//    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TAdditionalServicesWithPrices> additionalServiceWithPrices;
    @OneToMany
    private List<TComment> comments;
    @OneToOne(cascade = {CascadeType.ALL})
    private Pricelist pricelist;
    private int capacity;
    private int numberOfPeopleCapacity;



  public AccommodationForDatabase () {}


    public AccommodationForDatabase(Accommodation accommodation) {
        this.name = accommodation.getName() ;
        this.room = accommodation.getRoom() ;
        this.address = accommodation.getAddress();
        this.accommodationType = accommodation.getAccommodationType() ;
        this.description = accommodation.getDescription() ;
        this.accommodationCategory = accommodation.getAccommodationCategory() ;
        this.cancellation = accommodation.getCancellation();
        this.rate = accommodation.getRate();
        this.picture = accommodation.getPicture() ;
    //    this.agent = accommodation.getAgent() ;
        this.additionalServiceWithPrices = accommodation.getAdditionalServiceWithPrices() ;
        this.comments = accommodation.getComments();
        this.pricelist = accommodation.getPricelist() ;
        this.capacity = accommodation.getCapacity();
        this.numberOfPeopleCapacity = accommodation.getNumberOfPeopleCapacity() ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TRoom> getRoom() {
        if (room == null) {
            room = new ArrayList<>();
        }
        return this.room;
    }

    public void setRoom(List<TRoom> room) {
        this.room = room;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TAccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(TAccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TAccommodationCategory getAccommodationCategory() {
        return accommodationCategory;
    }

    public void setAccommodationCategory(TAccommodationCategory accommodationCategory) {
        this.accommodationCategory = accommodationCategory;
    }

    public TCancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(TCancellation cancellation) {
        this.cancellation = cancellation;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public List<String> getPicture() {

        if (picture == null) {
            picture = new ArrayList<>();
        }
        return this.picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<AgentForDatabase> getAgent()
    {
        if (agent == null) {
            agent = new ArrayList<AgentForDatabase>();
        }
        return this.agent;
    }

    public void setAgent(List<AgentForDatabase> agent) {
        this.agent = agent;
    }

    public List<TAdditionalServicesWithPrices> getAdditionalServiceWithPrices() {
        if (additionalServiceWithPrices == null) {
            additionalServiceWithPrices = new ArrayList<>();
        }
        return this.additionalServiceWithPrices;
    }

    public void setAdditionalServiceWithPrices(List<TAdditionalServicesWithPrices> additionalServiceWithPrices) {
        this.additionalServiceWithPrices = additionalServiceWithPrices;
    }

    public List<TComment> getComments()
    {
        if (comments == null) {
            comments = new ArrayList<TComment>();
        }
        return this.comments;
    }

    public void setComments(List<TComment> comments) {
        this.comments = comments;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfPeopleCapacity() {
        return numberOfPeopleCapacity;
    }

    public void setNumberOfPeopleCapacity(int numberOfPeopleCapacity) {
        this.numberOfPeopleCapacity = numberOfPeopleCapacity;
    }
}
