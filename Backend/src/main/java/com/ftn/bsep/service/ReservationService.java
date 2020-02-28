package com.ftn.bsep.service;

import com.ftn.bsep.model.ReservationForDatabase;
import com.ftn.bsep.model.modelGenerated.TRoom;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ReservationService {
    ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_Id (Date arrival, Date departure, Long id);
    boolean delete(ReservationForDatabase reservationForDatabase);
    ReservationForDatabase save (ReservationForDatabase reservationForDatabase);
    List<ReservationForDatabase> findAll();
    List<ReservationForDatabase> findReservationForDatabaseByArrivalDateGreaterThanEqual(Date date);
    List<ReservationForDatabase> findReservationForDatabaseByRoom(TRoom room);
    ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_IdAndRoom
            (Date arrivalDate, Date departureDate, Long userId, TRoom room);

    List<ReservationForDatabase> findReservationForDatabaseByArrivalDateGreaterThanEqualAndRoom(Date date,TRoom room);
}
