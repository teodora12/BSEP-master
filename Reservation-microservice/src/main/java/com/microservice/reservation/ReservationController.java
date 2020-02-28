package com.microservice.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity newReservation(@Valid @RequestBody StartReservationDto startReservationDto,
                                         @RequestHeader(value="Authorization") String authorization) {

        CreatedReservationDto reservation = this.reservationService.makeReservation(startReservationDto, UtilityService.getEmailFromToken(authorization));
        if(reservation == null){
            return new ResponseEntity<>("Fields are not valid!", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity getAllReservationsForUser(@RequestHeader(value="Authorization") String authorization) {
        List<CreatedReservationDto> reservations = this.reservationService.getAllUserReservations(UtilityService.getEmailFromToken(authorization));

        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancellReservation(@PathVariable Long id, @RequestHeader(value="Authorization") String authorization) {

         this.reservationService.cancellReservation(id);
        return ResponseEntity.ok().build();
    }
}
