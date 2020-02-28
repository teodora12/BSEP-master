package com.ftn.bsep.dto.accommodation;


import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateAndUpdateAccDTO {

    private Address address;

    private TAccommodationType type;

    @NotNull
    @NotBlank
    @SafeHtml
    private @SQLInjectionSafe String description;

    private List<String> pictures;

//    @NotNull
//    private boolean included;

    private List<AdditionalWithPricesDTO> additionalServicesWithPrices;

    private TAccommodationCategory category;

    private List<Agent> agents;

    private TCancellation cancellation;

    @NotNull
    @NotBlank
    @SafeHtml
    private @SQLInjectionSafe String name;

    private Long id;

    private PricelistDTO pricelist;

    @NotNull private  Integer capacity;


    public CreateAndUpdateAccDTO() {

    }

//    public boolean isIncluded() {
//        return included;
//    }
//
//    public void setIncluded(boolean included) {
//        this.included = included;
//    }

    public CreateAndUpdateAccDTO(Accommodation accommodation)
    {
     //   this.additionalServicesWithPrices = accommodation.getAdditionalService();
        this.name = accommodation.getName();
        this.address = accommodation.getAddress();
     //   this.agent = accommodation.getAgent();
        this.cancellation = accommodation.getCancellation();
        this.category = accommodation.getAccommodationCategory();
        this.description = accommodation.getDescription();
        this.pictures = accommodation.getPicture();
        this.type = accommodation.getAccommodationType();
  //      this.pricelist = new PricelistDTO(accommodation.getPricelist());

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

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
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


    public List<AdditionalWithPricesDTO> getAdditionalServicesWithPrices() {
        return additionalServicesWithPrices;
    }

    public void setAdditionalServicesWithPrices(List<AdditionalWithPricesDTO> additionalServicesWithPrices) {
        this.additionalServicesWithPrices = additionalServicesWithPrices;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
