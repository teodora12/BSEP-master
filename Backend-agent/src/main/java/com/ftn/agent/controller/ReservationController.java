package com.ftn.agent.controller;

import com.ftn.agent.dto.CreateReservationDTO;
import com.ftn.agent.model.Reservation;
import com.ftn.agent.restService.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('CREATE_RESERVATION')")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody CreateReservationDTO reservationDTO)  {

        Reservation reservation = this.reservationService.createReservation(reservationDTO);
        if(reservation==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservation,HttpStatus.OK);
    }


    @PutMapping(value = "/cancel/{id}")
    @PreAuthorize("hasAuthority('CHANGE_STATUS')")
    public ResponseEntity<Boolean> cancelReservation(@PathVariable Long id)  {

        boolean deleted = this.reservationService.changeReservationStatusToCanceled(id);
        if(deleted==false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/confirm/{id}")
    @PreAuthorize("hasAuthority('CHANGE_STATUS')")
    public ResponseEntity<Reservation> confirmReservation(@PathVariable Long id)  {

        Reservation reservation = this.reservationService.changeReservationStatusToRealized(id);
        if(reservation==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservation,HttpStatus.OK);
    }


    @GetMapping(value = "/agent/{username}")
    @PreAuthorize("hasAuthority('ALL_RESERVATIONS')")
    public ResponseEntity<List<Reservation>> getAgentsReservations(@Valid  @PathVariable String username){

        List<Reservation> reservations = this.reservationService.getAgentsReservations(username);
        if(reservations == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservations,HttpStatus.OK);

    }
}
