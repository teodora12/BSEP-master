package com.microservice.search;

import com.microservice.search.model.Accommodation;
import com.microservice.search.model.AccommodationSearchResult;
import com.microservice.search.model.TAdditionalService;
import com.microservice.search.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.web.client.RestTemplate;


@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private TAdditionalServicesWithPricesRepository tAdditionalServicesWithPricesRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final String USER_ADMIN_SERVICE_URI= "http://localhost:8762/user-admin-service/api/accommodation/pictures";



    @Override
    public Set search(AccommodationSearchDto accommodationSearchDto) {

        RegularExpressions regularExpressions = new RegularExpressions();

        boolean isNumberOfPeopleValid = regularExpressions.isNumberValid(accommodationSearchDto.getNumberOfPersons());
        boolean isDistanceValid = true;
        boolean isLongitudeValid = true;
        boolean isLatitudeValid = true;
        boolean isNumberOfDaysInCancelationValid = true;


        if(accommodationSearchDto.getDistance() != 0) {
             isDistanceValid = regularExpressions.isDoubleValid(accommodationSearchDto.getDistance());
        }

        if(accommodationSearchDto.getLongitude() != 0) {
            isLongitudeValid = regularExpressions.isLongitudeAndLatitudeValid(accommodationSearchDto.getLongitude());
        }
        if(accommodationSearchDto.getLatitude() != 0 ) {
            isLatitudeValid = regularExpressions.isLongitudeAndLatitudeValid(accommodationSearchDto.getLatitude());
        }
        if(accommodationSearchDto.getCancellation() != null) {
            isNumberOfDaysInCancelationValid = regularExpressions.isNumberValid(accommodationSearchDto.getCancellation().getDays());
        }


       if(!(isNumberOfDaysInCancelationValid || isNumberOfPeopleValid
               || isDistanceValid || isLongitudeValid || isLatitudeValid)){
           return null;
       }


        long categoryId = 0;
        if (accommodationSearchDto.getAccommodationCategory() != null) {
            categoryId = accommodationSearchDto.getAccommodationCategory().getId();
        }
        long typeId = 0;
        if (accommodationSearchDto.getAccommodationType() != null) {
            typeId = accommodationSearchDto.getAccommodationType().getId();
        }
        Set<Accommodation> accommodationSet = this.searchRepository.searchTemp(accommodationSearchDto.getCountry(),
                accommodationSearchDto.getTown()
                , categoryId, accommodationSearchDto.getAccommodationCategory(),
                typeId, accommodationSearchDto.getAccommodationType()
                , accommodationSearchDto.getFromDate(),
                accommodationSearchDto.getToDate(), accommodationSearchDto.getNumberOfPersons());

        Set<Accommodation> accommodationCancellationSet = new HashSet<>();
        if (accommodationSearchDto.getCancellation() != null) {
            for (Accommodation accommodation : accommodationSet) {
                if (accommodation.getCancellation().getDays() >= accommodationSearchDto.getCancellation().getDays()) {
                    accommodationCancellationSet.add(accommodation);
                }
            }
        } else {
            accommodationCancellationSet.addAll(accommodationSet);
        }

        HashMap<Long, Double> accommodationIdsWithDistance = new HashMap<Long, Double>();

        Set<Accommodation> accommodationDistanceSet = new HashSet<>();
        if (accommodationSearchDto.getDistance() > 0) {
            for (Accommodation accommodation : accommodationCancellationSet) {
                double distanceTemp = calculateDistanceInKm(accommodationSearchDto.getLatitude(), accommodationSearchDto.getLongitude(),
                        accommodation.getAddress().getLatitude(), accommodation.getAddress().getLongitude());

                if (distanceTemp <= accommodationSearchDto.getDistance()) {
                    accommodationDistanceSet.add(accommodation);
                    accommodationIdsWithDistance.put(accommodation.getId(), new Double(distanceTemp));
                }
            }
        } else {
            accommodationDistanceSet.addAll(accommodationCancellationSet);
        }

        Set<Accommodation> accommodationAdditionalSet = new HashSet<>();
        if (accommodationSearchDto.getAdditionalService() != null && !accommodationSearchDto.getAdditionalService().isEmpty()) {
            for (Accommodation accommodation : accommodationDistanceSet) {
                boolean accommodationFits = true;
                for (TAdditionalService tAdditionalService : accommodationSearchDto.getAdditionalService()) {
                    boolean isOk = this.tAdditionalServicesWithPricesRepository.doesAccommodationHaveAdditionalService(accommodation.getId(), tAdditionalService.getId());
                    if (!isOk) {
                        accommodationFits = false;
                        break;
                    }
                }
                if (accommodationFits) {
                    accommodationAdditionalSet.add(accommodation);
                }
            }
        } else {
            accommodationAdditionalSet.addAll(accommodationDistanceSet);
        }

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity requestEntity = new HttpEntity<>(accommodationAdditionalSet, requestHeaders);

        ResponseEntity<List<AccommodationIdPictureBytesDto>> resp =
                restTemplate.exchange(USER_ADMIN_SERVICE_URI, HttpMethod.POST,requestEntity,
                        new ParameterizedTypeReference<List<AccommodationIdPictureBytesDto>>(){});


        List<AccommodationIdPictureBytesDto> accommodationWithPictures = resp.getBody();
        Set<AccommodationSearchResult> finalList = new HashSet<>();


        for (Accommodation accommodation : accommodationAdditionalSet) {
            for (AccommodationIdPictureBytesDto accWithPictures : accommodationWithPictures) {
                if (accommodation.getId() == accWithPictures.getId()) {
                    AccommodationSearchResult finalAcc = new AccommodationSearchResult(accommodation);
                    finalAcc.setPicture(accWithPictures.getPicture());
                    if (accommodationSearchDto.getDistance() > 0 && !accommodationIdsWithDistance.isEmpty()) {
                        finalAcc.setDistance((accommodationIdsWithDistance.get(finalAcc.getId())).doubleValue());
                    } else {
                        finalAcc.setDistance(0);
                    }
                    finalList.add(finalAcc);
                    break;
                }
            }
        }


        return finalList;
    }

    private static final double AVERAGE_RADIUS_OF_EARTH_KM = 6371;

    private double calculateDistanceInKm(double userLat, double userLng, double accLat, double accLng) {
        double latDistance = Math.toRadians(userLat - accLat);
        double lngDistance = Math.toRadians(userLng - accLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(accLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return AVERAGE_RADIUS_OF_EARTH_KM * c;
    }
}
