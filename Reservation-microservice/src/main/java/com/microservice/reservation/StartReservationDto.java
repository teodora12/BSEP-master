package com.microservice.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservice.reservation.validation.SQLInjectionSafe;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class StartReservationDto {

    @NotNull
    private Long accommodationId;
    private List<Long> roomIds;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date arrivalDate;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date departureDate;
    @NotNull
    private int numberOfPeople;

    private List<TAdditionalServicesWithPrices> additionalServicesWithPrices;
}
