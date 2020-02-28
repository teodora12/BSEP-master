package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.ReservationForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.repository.*;
import com.ftn.bsep.service.AgentService;
import com.ftn.bsep.service.ReservationService;
import com.ftn.bsep.service.RoomService;
import com.ftn.bsep.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Endpoint
public class ReservationEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/accommodation";

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReserveRoomRequest")
    @ResponsePayload
    public ReserveRoomResponse reserveRoom(@RequestPayload ReserveRoomRequest request) {

        ReserveRoomResponse response = new ReserveRoomResponse();
        Reservation reservation = request.getReservation();
        List<TRoom> room = reservation.getRoom();                //sobe koju zelimo da rezervsemo
        String accommodationName = request.getAccommodationName();

        AccommodationForDatabase accommodation = this.accommodationRepository.findAccommodationForDatabaseByName(accommodationName);
        com.ftn.bsep.model.User user = this.userService.findUserByMail(reservation.getUser().getEmail());

        List<TRoom> rooms = accommodation.getRoom();         // sve sobe accommodationa u kom zelimo da rezervisemo

        List<ReservationForDatabase> roomReservations = new ArrayList<>();    // sve rezervacije sobe koju zelimo da rezervisemo

        List<TRoom> roomInBackendBase = new ArrayList<>();

        for (TRoom r: rooms){
            BigInteger roomNum = r.getRoomNumber();
            if(room.get(0).getRoomNumber().equals(roomNum)) {
                roomInBackendBase.add(r);
                roomReservations = reservationRepository.findReservationsByRoom(r);

            }
        }
        //posle naseg termina odlaska u sobi koju zelimo
        List<ReservationForDatabase> afterOurDeparture = this.reservationRepository.findReservationsForDatabaseByDepartureDateGreaterThanAndRoom(reservation.getDepartureDate(),roomInBackendBase.get(0));

        if(roomReservations.size() != 0) {
            List<ReservationForDatabase> finalRoomReservations = roomReservations;
            afterOurDeparture.forEach(roomForDelete -> {
                if (finalRoomReservations.contains(roomForDelete)) {
                    finalRoomReservations.remove(roomForDelete);
                }
            });


            for (ReservationForDatabase res : roomReservations) {

                if ((reservation.getArrivalDate().before(res.getDepartureDate()))) {

                    response.setSuccess(false);
                    return response;
                }

            }
        }

        List<TAdditionalService> additionalServices = new ArrayList<>();
        ReservationForDatabase resForDatabase = new ReservationForDatabase(reservation.getPrice(),
                user, reservation.getArrivalDate(), reservation.getDepartureDate(),roomInBackendBase, reservation.getNumberOfDaysForCancellation(),
                additionalServices, accommodation.getId());

        resForDatabase.setStatus("created");
        this.reservationService.save(resForDatabase);
        response.setSuccess(true);


        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetReservationsRequest")
    @ResponsePayload
    public GetReservationsResponse getReservations(@RequestPayload GetReservationsRequest request) {

        Agent agent = agentService.findAgentByUsername(request.getUsername());

        List<AccommodationForDatabase> accommodations = accommodationRepository.findAccommodationsByAgent_Id(agent.getId());

        List<TRoom> allRooms = new ArrayList<>();
        for (AccommodationForDatabase a: accommodations) {
            List<TRoom> rooms = a.getRoom();
            allRooms.addAll(rooms);

        }

        List<Reservation> reservations = new ArrayList<>();

        for (TRoom room: allRooms){
            List<ReservationForDatabase> reservationsTemp = reservationRepository.findReservationsByRoom(room);
            if (reservationsTemp != null) {
                for(ReservationForDatabase reservationTemp: reservationsTemp) {
                    Reservation newReservation = new Reservation(reservationTemp.getNumberOfDaysForCancellation(),reservationTemp.getPaidAdditionalServices(),reservationTemp.getAccommodationId(),reservationTemp.getId(),reservationTemp.getStatus(), reservationTemp.getPrice(), new User(reservationTemp.getUser()),
                            reservationTemp.getArrivalDate(), reservationTemp.getDepartureDate(),
                            reservationTemp.getRoom());

                    reservations.add(newReservation);
                }
            }
        }


        GetReservationsResponse response = new GetReservationsResponse();
        response.getReservation().addAll(reservations);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ChangeReservationStatusRequest")
    @ResponsePayload
    public ChangeReservationStatusResponse changeReservationStatus(@RequestPayload ChangeReservationStatusRequest request) {

        ChangeReservationStatusResponse response = new ChangeReservationStatusResponse();

        String email = request.getReservation().getUser().getEmail();
        com.ftn.bsep.model.User userForDatabase = this.userService.findUserByMail(email);
        Reservation reservation = request.getReservation();
        AccommodationForDatabase accommodation = this.accommodationRepository.findAccommodationForDatabaseByName(reservation.getRoom().get(0).getAccommodationName());
        List<TRoom> room = this.roomService.findRoomsByRoomNumberAndAccName(reservation.getRoom().get(0).getRoomNumber(),reservation.getRoom().get(0).getAccommodationName());
        ReservationForDatabase reservationForDatabase = this.reservationService.findReservationForDatabaseByArrivalDateAndDepartureDateAndUser_IdAndRoom
                (reservation.getArrivalDate(),reservation.getDepartureDate(), userForDatabase.getId(),room.get(0));

        if(reservationForDatabase != null) {

            reservationForDatabase.setStatus(reservation.getStatus());
            if (reservationForDatabase.getStatus().equals("canceled")) {
                this.reservationService.delete(reservationForDatabase);
                response.setSuccess(true);
                return response;
            }

            if (reservationForDatabase.getStatus().equals("realized")) {
                this.reservationService.save(reservationForDatabase);
                response.setSuccess(true);
                return response;
            }
        }


        response.setSuccess(false);
        return response;
    }


}
