package com.microservice.reservation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    CreatedReservationDto makeReservation(StartReservationDto startReservationDto, String email);
    List<CreatedReservationDto> getAllUserReservations(String email);
    void cancellReservation(Long id);
}
