package com.ftn.agent.dto;

import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class AccommodationDTO {

    private long id;
    private String name;
    private List<TRoom> room;
    private Address address;
    private TAccommodationType accommodationType;
    private String description;
    private TAccommodationCategory accommodationCategory;
    private TCancellation cancellation;
    private double rate;
    private List<String> picture;
    private List<AgentDTO> agent;
    private List<TAdditionalServicesWithPrices> additionalServiceWithPrices;
    private List<TComment> comments;
    private Pricelist pricelist;
    private int capacity;
    private int numberOfPeopleCapacity;


    public AccommodationDTO(){

    }


    public AccommodationDTO(AccommodationForDatabase accommodationForDatabase) {
        this.id = accommodationForDatabase.getId();
        this.name = accommodationForDatabase.getName();
        this.room = accommodationForDatabase.getRoom();
        this.address = accommodationForDatabase.getAddress();
        this.accommodationType = accommodationForDatabase.getAccommodationType();
        this.description = accommodationForDatabase.getDescription();
        this.accommodationCategory = accommodationForDatabase.getAccommodationCategory();
        this.cancellation = accommodationForDatabase.getCancellation();
        this.rate = accommodationForDatabase.getRate();
        this.picture = accommodationForDatabase.getPicture();
        List<AgentDTO> list = new ArrayList<>();
        for(AgentForDatabase a: accommodationForDatabase.getAgent()){
            AgentDTO dto = new AgentDTO(a);
            list.add(dto);
        }
        this.agent = list;
        this.additionalServiceWithPrices = accommodationForDatabase.getAdditionalServiceWithPrices();
        this.comments = accommodationForDatabase.getComments();
        this.pricelist = accommodationForDatabase.getPricelist();
        this.capacity = accommodationForDatabase.getCapacity();
        this.numberOfPeopleCapacity = accommodationForDatabase.getNumberOfPeopleCapacity();
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

    public List<AgentDTO> getAgent() {
        return agent;
    }

    public void setAgent(List<AgentDTO> agent) {
        this.agent = agent;
    }

    public List<TAdditionalServicesWithPrices> getAdditionalServiceWithPrices() {
        return additionalServiceWithPrices;
    }

    public void setAdditionalServiceWithPrices(List<TAdditionalServicesWithPrices> additionalServiceWithPrices) {
        this.additionalServiceWithPrices = additionalServiceWithPrices;
    }

    public List<TComment> getComments() {
        return comments;
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
