package com.ftn.bsep.dto.accommodation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import com.ftn.bsep.model.modelGenerated.TCancellation;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Salje se pri searchu, sadrzi sve elemente potrebne za trazenje, prosledjuje se search microservice-u
 * */

@Data
public class SearchAccommodation {

    private String town;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fromDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date toDate;
    private int numberOfPersons;
    private TAccommodationType accommodationType;
    private TAccommodationCategory accommodationCategory;
    private double distance;
    private List<TAdditionalService> additionalService;
    private TCancellation cancellation;
    private double longitude;
    private double latitude;


}
