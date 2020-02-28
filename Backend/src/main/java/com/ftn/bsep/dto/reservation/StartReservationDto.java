package com.ftn.bsep.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ftn.bsep.model.modelGenerated.TAdditionalServicesWithPrices;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StartReservationDto {

    private Long accommodationId;
    private List<Long> roomIds;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrivalDate;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureDate;
    private int numberOfPeople;
    private String email;
    private List<TAdditionalServicesWithPrices> additionalServicesWithPrices;

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TAdditionalServicesWithPrices> getAdditionalServicesWithPrices() {
        return additionalServicesWithPrices;
    }

    public void setAdditionalServicesWithPrices(List<TAdditionalServicesWithPrices> additionalServicesWithPrices) {
        this.additionalServicesWithPrices = additionalServicesWithPrices;
    }
}
