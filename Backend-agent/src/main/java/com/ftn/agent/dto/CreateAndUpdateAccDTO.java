package com.ftn.agent.dto;

import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateAndUpdateAccDTO {

    private Address address;

    private TAccommodationType type;

    private String description;

    private List<String> pictures;

    private List<TAdditionalService> additionalServices;

    private List<TRoom> rooms;

    private TAccommodationCategory category;

    private Agent agent;

    private TCancellation cancellation;

    private String name;

    private Long id;

    private PricelistDTO pricelist;


    public CreateAndUpdateAccDTO() {

        this.rooms = new ArrayList<>();

    }



    public CreateAndUpdateAccDTO(Accommodation accommodation)
    {
     //   this.additionalServicesWithPrices = accommodation.getAdditionalService();
        this.name = accommodation.getName();
        this.address = accommodation.getAddress();
      //  this.agent = accommodation.getAgent();
        this.cancellation = accommodation.getCancellation();
        this.category = accommodation.getAccommodationCategory();
        this.description = accommodation.getDescription();
        this.pictures = accommodation.getPicture();
        this.type = accommodation.getAccommodationType();
        this.pricelist = new PricelistDTO(accommodation.getPricelist());
        this.id= accommodation.getId();
        this.rooms = accommodation.getRoom();

    }


    public CreateAndUpdateAccDTO(AccommodationForDatabase accommodation)
    {
        //   this.additionalServicesWithPrices = accommodation.getAdditionalService();
        this.name = accommodation.getName();
        this.address = accommodation.getAddress();
        //  this.agent = accommodation.getAgent();
        this.cancellation = accommodation.getCancellation();
        this.category = accommodation.getAccommodationCategory();
        this.description = accommodation.getDescription();
        this.pictures = accommodation.getPicture();
        this.type = accommodation.getAccommodationType();
        this.pricelist = new PricelistDTO(accommodation.getPricelist());
        this.id= accommodation.getId();
        this.rooms = accommodation.getRoom();

    }






    public PricelistDTO getPricelist() {
        return pricelist;
    }

    public void setPricelist(PricelistDTO pricelist) {
        this.pricelist = pricelist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TCancellation getCancellation() {
        return cancellation;
    }

    public void setCancellation(TCancellation cancellation) {
        this.cancellation = cancellation;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public TAccommodationCategory getCategory() {
        return category;
    }

    public void setCategory(TAccommodationCategory category) {
        this.category = category;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TAccommodationType getType() {
        return type;
    }

    public void setType(TAccommodationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }


    public List<TAdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<TAdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
