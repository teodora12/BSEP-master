package com.ftn.bsep.dto.accommodation;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.CommentForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import lombok.Data;

import java.util.List;
@Data
public class AccommodationWithBytePictures {

    private long id;

    private String name;

    private List<TRoom> room;

    private Address address;

    private TAccommodationType accommodationType;

    private String description;

    private TAccommodationCategory accommodationCategory;

    private TCancellation cancellation;

    private double rate;

    private List<byte[]> picture;

    private List<Agent> agent;

    private List<TAdditionalServicesWithPrices> additionalServicesWithPrices;

    private List<CommentForDatabase> comments;

    private Pricelist pricelist;

    private int capacity;

    private int numberOfPeopleCapacity;

    public AccommodationWithBytePictures(AccommodationForDatabase accommodation) {
        this.id = accommodation.getId();
        this.accommodationCategory = accommodation.getAccommodationCategory();
        this.accommodationType = accommodation.getAccommodationType();
        this.additionalServicesWithPrices = accommodation.getAdditionalServicesWithPrices();
        this.cancellation = accommodation.getCancellation();
        this.name = accommodation.getName();
        this.room = accommodation.getRoom();
        this.address = accommodation.getAddress();
        this.description = accommodation.getDescription();
        this.agent = accommodation.getAgent();
        this.rate = accommodation.getRate();
        this.pricelist = accommodation.getPricelist();
        this.capacity = accommodation.getCapacity();
        this.numberOfPeopleCapacity = accommodation.getNumberOfPeopleCapacity();
        this.comments = accommodation.getComments();

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

    public List<byte[]> getPicture() {
        return picture;
    }

    public void setPicture(List<byte[]> picture) {
        this.picture = picture;
    }

    public List<Agent> getAgent() {
        return agent;
    }

    public void setAgent(List<Agent> agent) {
        this.agent = agent;
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
