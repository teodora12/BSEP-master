package com.microservice.search.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class GetFreeRoomByAccommodationDto {
    @NotNull
    private Long accommodationId;
    @NotNull
    private Date fromDate;
    @NotNull
    private Date toDate;
    @NotNull
    private int numberOfPersons;
}
