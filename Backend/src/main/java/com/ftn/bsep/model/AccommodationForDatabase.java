package com.ftn.bsep.model;

import com.ftn.bsep.model.modelGenerated.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "accommodation")
@Table(name = "accommodation")
public class AccommodationForDatabase {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TRoom> room;

    @OneToOne
    private Address address;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private TAccommodationType accommodationType;

    @Column
    private String description;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private TAccommodationCategory accommodationCategory;

    @OneToOne
    private TCancellation cancellation;

    @Column
    private double rate;

    @ElementCollection
    @Column(name="picture")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> picture;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Agent> agent;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TAdditionalServicesWithPrices> additionalServicesWithPrices;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentForDatabase> comments;

    @OneToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private Pricelist pricelist;

    @Column
    private Integer capacity;

    @Column
    private Integer numberOfPeopleCapacity;


    public AccommodationForDatabase() {}

    public AccommodationForDatabase(Accommodation accommodation){

//        this.id = accommodation.getId();              ???
        this.accommodationCategory = accommodation.getAccommodationCategory();
        this.accommodationType = accommodation.getAccommodationType();
        this.additionalServicesWithPrices = accommodation.getAdditionalServiceWithPrices();
        this.cancellation = accommodation.getCancellation();
        this.name = accommodation.getName();
        this.room = accommodation.getRoom();
        this.address = accommodation.getAddress();
        this.description = accommodation.getDescription();
        this.picture = accommodation.getPicture();
        this.agent = accommodation.getAgent();
        this.rate = accommodation.getRate();
        this.pricelist = accommodation.getPricelist();
        this.capacity = accommodation.getCapacity();
        this.numberOfPeopleCapacity = accommodation.getNumberOfPeopleCapacity();
        List<CommentForDatabase> commentForDatabases = new ArrayList<>();

//        for(TComment c: accommodation.getComments())   {
//
//            com.ftn.bsep.model.modelGenerated.User XMLUser = c.getUser();
//            User user = new User(XMLUser);
//            CommentForDatabase commentForDatabase = new CommentForDatabase(c, user);
//            commentForDatabases.add(commentForDatabase);
//
//        }


        this.comments = commentForDatabases;


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
        return room;
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
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }

    public List<Agent> getAgents() {
        return agent;
    }

    public void setAgents(List<Agent> agents) {
        this.agent = agents;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public List<TAdditionalServicesWithPrices> getAdditionalServicesWithPrices() {
        return additionalServicesWithPrices;
    }

    public void setAdditionalServicesWithPrices(List<TAdditionalServicesWithPrices> additionalServicesWithPrices) {
        this.additionalServicesWithPrices = additionalServicesWithPrices;
    }

    public List<CommentForDatabase> getComments() {
        return comments;
    }

    public void setComments(List<CommentForDatabase> comments) {
        this.comments = comments;
    }

    public List<Agent> getAgent() {
        return agent;
    }

    public void setAgent(List<Agent> agent) {
        this.agent = agent;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public int getNumberOfPeopleCapacity() {
        return numberOfPeopleCapacity;
    }

    public void setNumberOfPeopleCapacity(Integer numberOfPeopleCapacity) {
        this.numberOfPeopleCapacity = numberOfPeopleCapacity;
    }
}
