package com.ftn.bsep.dto.reservation;

import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import com.ftn.bsep.model.modelGenerated.TRoom;
import lombok.Data;

import java.math.BigDecimal;
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
}
