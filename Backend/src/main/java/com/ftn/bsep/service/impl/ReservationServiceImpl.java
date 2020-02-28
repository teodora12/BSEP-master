package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.ReservationForDatabase;
import com.ftn.bsep.model.User;
import com.ftn.bsep.model.modelGenerated.TRoom;
import com.ftn.bsep.repository.ReservationRepository;
import com.ftn.bsep.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_Id(Date arrival, Date departure, Long id) {
        return this.reservationRepository.findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_Id(arrival,departure, id);
    }

    @Override
    public boolean delete(ReservationForDatabase reservationForDatabase) {
        this.reservationRepository.delete(reservationForDatabase);
        return true;
    }

    @Override
    public ReservationForDatabase save(ReservationForDatabase reservationForDatabase) {
        return this.reservationRepository.save(reservationForDatabase);
    }

    @Override
    public List<ReservationForDatabase> findAll() {
        return this.reservationRepository.findAll();
    }

    @Override
    public List<ReservationForDatabase> findReservationForDatabaseByArrivalDateGreaterThanEqual(Date date) {
        return this.reservationRepository.findReservationForDatabaseByArrivalDateGreaterThanEqual(date);
    }

    @Override
    public List<ReservationForDatabase> findReservationForDatabaseByRoom(TRoom room) {
        return this.reservationRepository.findReservationsByRoom(room);
    }

    @Override
    public List<ReservationForDatabase> findReservationForDatabaseByArrivalDateGreaterThanEqualAndRoom(Date date, TRoom room) {
        return this.reservationRepository.findReservationsByArrivalDateGreaterThanEqualAndRoom(date,room);
    }


    @Override
    public ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_IdAndRoom(Date arrivalDate, Date departureDate, Long userId, TRoom room) {
        return this.reservationRepository.findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_IdAndRoom(arrivalDate,departureDate,userId,room);
    }
}
