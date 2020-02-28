package com.microservice.search.model;

import java.util.ArrayList;
import java.util.List;

public class AccommodationSearchResult {

    private Long id;
    private String name;
    private Address address;
    private List<TRoom> room;
    private String description;
    private TAccommodationType accommodationType;
    private TAccommodationCategory accommodationCategory;
    private List<TAdditionalServicesWithPrices> additionalService;
    private TCancellation cancellation;
    private double rate;
    private List<byte[]> picture;
    private Pricelist pricelist;
    private double distance;

    public AccommodationSearchResult(Accommodation accommodation) {
        id = accommodation.getId();
        name = accommodation.getName();
        address = accommodation.getAddress();
        room = accommodation.getRoom();
        description = accommodation.getDescription();
        accommodationType = accommodation.getAccommodationType();
        accommodationCategory = accommodation.getAccommodationCategory();
        additionalService = accommodation.getAdditionalServicesWithPrices();
        cancellation = accommodation.getCancellation();
        rate = accommodation.getRate();
        pricelist = accommodation.getPricelist();
        picture = new ArrayList<>();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<TRoom> getRoom() {
        return room;
    }

    public void setRoom(List<TRoom> room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TAccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(TAccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public TAccommodationCategory getAccommodationCategory() {
        return accommodationCategory;
    }

    public void setAccommodationCategory(TAccommodationCategory accommodationCategory) {
        this.accommodationCategory = accommodationCategory;
    }

    public List<TAdditionalServicesWithPrices> getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(List<TAdditionalServicesWithPrices> additionalService) {
        this.additionalService = additionalService;
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

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
