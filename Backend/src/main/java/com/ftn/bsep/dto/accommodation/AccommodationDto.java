package com.ftn.bsep.dto.accommodation;

import com.ftn.bsep.model.modelGenerated.*;
import lombok.Data;

import java.util.List;

/**
 *  Povratna vrednost pri searchu
 * */

@Data
public class AccommodationDto {

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
    private List<String> picture;
    private Pricelist pricelist;
    private Integer capacity;
}
