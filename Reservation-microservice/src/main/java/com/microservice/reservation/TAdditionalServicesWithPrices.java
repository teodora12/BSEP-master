package com.microservice.reservation;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TAdditionalServicesWithPrices {

    @NotNull
    private Long id;

    private TAdditionalService additionalService;

    @NotNull
    private double price;
}
