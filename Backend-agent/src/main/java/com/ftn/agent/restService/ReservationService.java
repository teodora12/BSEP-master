package com.ftn.agent.restService;

import com.ftn.agent.dto.CreateReservationDTO;
import com.ftn.agent.model.Reservation;
import com.ftn.agent.model.TRoom;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Service
public interface ReservationService {

    Reservation createReservation(CreateReservationDTO createReservationDTO);

    List<Reservation> getAgentsReservations(String username);

    boolean changeReservationStatusToCanceled(Long id);

    Reservation changeReservationStatusToRealized(Long id);

    List<Reservation> getReservationsByRoom(TRoom room);

    List<Reservation> findReservationsByArrivalDateGreaterThanEqual(Date date);

    void deleteReservations(List<Reservation> reservations);

    List<Reservation> findReservationsByArrivalDateGreaterThanEqualAndRoom(Date date,TRoom room);

}
