package com.ftn.bsep.controller;

import com.ftn.bsep.dto.reservation.CreatedReservationDto;
import com.ftn.bsep.dto.reservation.StartReservationDto;
import com.ftn.bsep.model.modelGenerated.Reservation;
import com.ftn.bsep.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccommodationReservationController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String RESERVATION_SERVICE_URI= "https://localhost:8081/api/reservation";

    @PostMapping
    @PreAuthorize("hasAuthority('WRITE_RESERVATION')")
    public ResponseEntity searchAccommodation(@RequestBody StartReservationDto reservationDto,
                                              @RequestHeader(value="Authorization") String authorization) {

        reservationDto.setEmail(UtilityService.getEmailFromToken(authorization));

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", authorization);

        HttpEntity requestEntity = new HttpEntity<>(reservationDto, requestHeaders);

        ResponseEntity resp = restTemplate.exchange(RESERVATION_SERVICE_URI, HttpMethod.POST,requestEntity, CreatedReservationDto.class);
        return new ResponseEntity(resp.getBody(), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_RESERVATION')")
    public ResponseEntity<List<CreatedReservationDto>> getReservationsForLoggedUser(
                                              @RequestHeader(value="Authorization") String authorization) {


        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", authorization);

        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity resp = restTemplate.exchange(RESERVATION_SERVICE_URI+"/{email}", HttpMethod.GET,requestEntity, CreatedReservationDto[].class, UtilityService.getEmailFromToken(authorization));
        return new ResponseEntity(resp.getBody(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_RESERVATION')")
    public ResponseEntity cancellReservation(
            @RequestHeader(value = "Authorization") String authorization, @PathVariable String id) {


        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.add("Authorization", authorization);

        HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity resp = restTemplate.exchange(RESERVATION_SERVICE_URI+"/{id}", HttpMethod.DELETE,requestEntity,
                CreatedReservationDto[].class, id);
        if (resp.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok().build();

        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
    }


}
