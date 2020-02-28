package com.ftn.agent.repository;

import com.ftn.agent.model.Reservation;
import com.ftn.agent.model.TRoom;
import com.ftn.agent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findReservationById(Long id);
    Reservation findReservationByUserAndArrivalDate(User user, Date arrivalDate);
    Reservation findReservationByUserAndArrivalDateAndDepartureDateAndRoom(User user, Date arrivalDate, Date departureDate, TRoom room);
    List<Reservation> findReservationByRoom (TRoom room);
    List<Reservation> findReservationsByArrivalDateGreaterThanEqual(Date date);
    List<Reservation> findReservationsByArrivalDateGreaterThanEqualAndRoom(Date date,TRoom room);
}
