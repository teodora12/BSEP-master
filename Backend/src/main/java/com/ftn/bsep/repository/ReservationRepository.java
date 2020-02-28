package com.ftn.bsep.repository;

import com.ftn.bsep.model.ReservationForDatabase;
import com.ftn.bsep.model.User;
import com.ftn.bsep.model.modelGenerated.TRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationForDatabase, Long> {

    List<ReservationForDatabase> findReservationsByRoom(TRoom room);
 //   ReservationForDatabase findReservationByRoom(TRoom room);
    ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_Id
            (Date arrival, Date departure, Long id);
    ReservationForDatabase findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_IdAndRoom
            (Date arrival, Date departure, Long id, TRoom room);
    List<ReservationForDatabase> findReservationsForDatabaseByDepartureDateGreaterThanAndRoom(Date departureDate, TRoom room);
    List<ReservationForDatabase> findReservationForDatabaseByArrivalDateGreaterThanEqual(Date date);
    List<ReservationForDatabase> findReservationsByArrivalDateGreaterThanEqualAndRoom(Date date,TRoom room);


}
