package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.dto.CreateReservationDTO;
import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import com.ftn.agent.repository.ReservationRepository;
import com.ftn.agent.restService.*;
import com.ftn.agent.soapService.SOAPConnectorReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private SOAPConnectorReservation soapConnectorReservation;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AdditionalServiceServiceImpl additionalServiceService;

    @Autowired
    private AccommodationService accommodationService;

    @Override
    public List<Reservation> getAgentsReservations(String username) {


//        List<Accommodation> agentAccommodations = this.accommodationService.getAccommodationByAgentUsername(username);
//
//        List<TRoom> allRooms = new ArrayList<>();
//        for (Accommodation a: agentAccommodations) {
//            List<TRoom> rooms = a.getRoom();
//            allRooms.addAll(rooms);
//
//        }
//        List<Reservation> allReservations = new ArrayList<>();
//        for (TRoom room: allRooms) {
//            List<Reservation> agentReservations = this.reservationRepository.findReservationByRoom(room);
//            if(agentReservations.size() != 0) {
//                allReservations.addAll(agentReservations);
//            }
//        }
//
//        for(Reservation r: allReservations){
//            r.getPaidAdditionalServices().removeAll(r.getPaidAdditionalServices());
//            r.getRoom().removeAll(r.getRoom());
//
//            this.reservationRepository.delete(r);
//        }
//        allReservations.removeAll(allReservations);
//        this.reservationRepository.deleteAll(allReservations);
//    //    this.reservationRepository.saveAll(allReservations);
//
//
//
//

        GetReservationsResponse response = this.soapConnectorReservation.getReservationsResponse(username);
        List<Reservation> agentReservations = new ArrayList<>();
        if(response ==null || response.getReservation() == null){
            return null;
        }

        for(Reservation reservation: response.getReservation()){

            User user = this.userService.findUserByEmail(reservation.getUser().getEmail());
            TRoom roomInDataBase = this.roomService.findRoomByAccNameAndRoomNumber(reservation.getRoom().get(0).getAccommodationName(),reservation.getRoom().get(0).getRoomNumber());
            Reservation resInAgentDataBase = this.reservationRepository.findReservationByUserAndArrivalDateAndDepartureDateAndRoom(user,reservation.getArrivalDate(),reservation.getDepartureDate(),roomInDataBase);

            if(user != null && resInAgentDataBase != null) {

                    resInAgentDataBase.setStatus(reservation.getStatus());
                    agentReservations.add(resInAgentDataBase);
                    this.reservationRepository.save(resInAgentDataBase);
            }


            else if(user == null){
                User newUser = new User(reservation.getUser());
                if(reservation.getUser().getAddress() != null) {
                    Address address = new Address(reservation.getUser().getAddress());
                    this.addressService.save(address);
                    newUser.setAddress(address);
                }
                this.userService.save(newUser);
       //         Reservation r = this.reservationRepository.findReservationByUserAndArrivalDate(newUser,reservation.getArrivalDate());
        //        if(r == null){

                    List<TRoom> reservationRooms = reservation.getRoom();
                    List<TRoom> newRooms = new ArrayList<>();

                    for(TRoom r: reservationRooms){
                        TRoom room = this.roomService.findRoomByAccNameAndRoomNumber(r.getAccommodationName(),r.getRoomNumber());
                        newRooms.add(room);
                    }


                    Reservation newReservation = new Reservation();
                    newReservation.setUser(newUser);
                    newReservation.setAccommodationId(reservation.getAccommodationId());
                    newReservation.setNumberOfDaysForCancellation(reservation.getNumberOfDaysForCancellation());

                    List<TAdditionalService> newAdditionalServices = new ArrayList<>();
                    for(TAdditionalService ad: reservation.getPaidAdditionalServices()){
                        TAdditionalService newAdditional = this.additionalServiceService.findByName(ad.getName());
                        newAdditionalServices.add(newAdditional);

                    }

                    newReservation.getPaidAdditionalServices().addAll(newAdditionalServices);
                    newReservation.setStatus(reservation.getStatus());
                    newReservation.setPrice(reservation.getPrice());
                    newReservation.setArrivalDate(reservation.getArrivalDate());
                    newReservation.setDepartureDate(reservation.getDepartureDate());
                    newReservation.getRoom().addAll(newRooms);

                    agentReservations.add(newReservation);
                    this.reservationRepository.save(newReservation);
            //    }

            } else {
                Reservation r = this.reservationRepository.findReservationByUserAndArrivalDate(user, reservation.getArrivalDate());
                if(r == null){
                    List<TRoom> reservationRooms = reservation.getRoom();
                    List<TRoom> newRooms = new ArrayList<>();

                    for(TRoom ro: reservationRooms){
                        TRoom room = this.roomService.findRoomByAccNameAndRoomNumber(ro.getAccommodationName(),ro.getRoomNumber());
                        newRooms.add(room);
                    }


                    Reservation newReservation = new Reservation();
                    newReservation.setUser(user);
                    newReservation.setStatus(reservation.getStatus());
                    newReservation.setPrice(reservation.getPrice());
                    newReservation.setArrivalDate(reservation.getArrivalDate());
                    newReservation.setDepartureDate(reservation.getDepartureDate());
                    newReservation.getRoom().addAll(newRooms);
                    agentReservations.add(newReservation);
                    this.reservationRepository.save(newReservation);
                }

            }
        }
        return agentReservations;
    }

    @Override
    public boolean changeReservationStatusToCanceled(Long id) {

        Reservation reservation = this.reservationRepository.findReservationById(id);
        if (reservation== null){
            return false;
        }
        reservation.setStatus("canceled");

        ChangeReservationStatusResponse response = this.soapConnectorReservation.changeReservationStatus(reservation);

        if(response.isSuccess() == true) {
            this.reservationRepository.delete(reservation);
            return true;
        }
        return false;
    }

    @Override
    public Reservation changeReservationStatusToRealized(Long id) {

        Reservation reservation = this.reservationRepository.findReservationById(id);
        reservation.setStatus("realized");

        ChangeReservationStatusResponse response = this.soapConnectorReservation.changeReservationStatus(reservation);

        if(response.isSuccess() == true) {
            this.reservationRepository.save(reservation);
            return reservation;
        }


        return null;

    }

    @Override
    public List<Reservation> getReservationsByRoom(TRoom room) {
        return this.reservationRepository.findReservationByRoom(room);
    }

    @Override
    public List<Reservation> findReservationsByArrivalDateGreaterThanEqual(Date date) {
        return this.reservationRepository.findReservationsByArrivalDateGreaterThanEqual(date);
    }

    @Override
    public void deleteReservations(List<Reservation> reservations) {
        this.reservationRepository.deleteAll(reservations);
    }

    @Override
    public List<Reservation> findReservationsByArrivalDateGreaterThanEqualAndRoom(Date date, TRoom room) {
        return this.reservationRepository.findReservationsByArrivalDateGreaterThanEqualAndRoom(date,room);
    }


    @Override
    public Reservation createReservation(CreateReservationDTO createReservationDTO) {




        Reservation reservation = new Reservation(createReservationDTO);
        User user = userService.findUserByEmail(createReservationDTO.getAgentUsername());
        TRoom room = roomService.findRoomById(createReservationDTO.getRoomId());
        reservation.getRoom().add(room);
        reservation.setUser(user);

        ReserveRoomResponse response = this.soapConnectorReservation.reserveRoomResponse(reservation,createReservationDTO.getAccommodationName());


        if(response.isSuccess() == false){
            return null;
        }
        AccommodationForDatabase accommodation = this.accommodationService.findAccommodationByName(createReservationDTO.getAccommodationName());

        reservation.setAccommodationId(accommodation.getId());
        reservation.setStatus("created");
        this.reservationRepository.save(reservation);

        return reservation;
    }


}
