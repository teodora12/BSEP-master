package com.microservice.search;

import com.microservice.search.model.*;
import com.microservice.search.validation.SQLInjectionSafe;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class AccommodationSearchDto {


    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String town;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String country;
    @NotNull
    private Date fromDate;
    @NotNull
    private Date toDate;
    @NotNull
    private int numberOfPersons;
    private TAccommodationType accommodationType;
    private TAccommodationCategory accommodationCategory;
    private double distance;
    private double longitude;
    private double latitude;
    private List<TAdditionalService> additionalService;
    private TCancellation cancellation;

}
