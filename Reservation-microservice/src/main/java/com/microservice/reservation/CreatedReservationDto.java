package com.microservice.reservation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CreatedReservationDto {

    private long id;
    private BigDecimal price;
    private Date arrivalDate;
    private Date departureDate;
    private List<TRoom> room;
    private String userEmail;
    private List<TAdditionalService> paidAdditionalServices;
    private Long numberOfDaysForCancellation;
    private Long accommodationId;

    public CreatedReservationDto(Long id, BigDecimal price, Date arrivalDate, Date departureDate, List<TRoom> room,
                                 String userEmail, List<TAdditionalService> paidAdditionalServices,
                                 Long numberOfDaysForCancellation, Long accommodationId) {
        this.id = id;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.room = new ArrayList<>();
        this.room.addAll(room);
        this.userEmail = userEmail;
        this.paidAdditionalServices = paidAdditionalServices;
        this.numberOfDaysForCancellation = numberOfDaysForCancellation;
        this.accommodationId = accommodationId;
    }
}