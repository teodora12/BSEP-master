package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.ReservationForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.repository.*;
import com.ftn.bsep.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Endpoint
public class AccommodationEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/accommodation";

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AgentService agentService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CancellationService cancellationService;


    @Autowired
    private RoomService roomService;

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AdditionalServicePriceService additionalServicePriceService;

//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateAccommodationRequest")
//    @ResponsePayload
//    public CreateAccommodationResponse createAccommodation(@RequestPayload CreateAccommodationRequest request) {
//
//        Accommodation accommodation = request.getAccommodation();
//        AccommodationForDatabase ac = this.accommodationRepository.findAccommodationForDatabaseByName(accommodation.getName());
//        CreateAccommodationResponse response = new CreateAccommodationResponse();
//        if(ac == null) {
//
////            if(accommodation.getPricelist() != null){
////                itemService.saveAll(accommodation.getPricelist().getItem());
////             //   pricelistService.save(accommodation.getPricelist());
////
////            }
//
//            if(accommodation.getCancellation() != null) {
//                cancellationService.save(accommodation.getCancellation());
//            }
//
//            if(accommodation.getRoom() != null) {
//                for(TRoom r: accommodation.getRoom()){
//                    roomService.save(r);
//                }
//
//            }
//            if(accommodation.getAddress() != null){
//                addressService.save(accommodation.getAddress());
//            }
//
//            this.additionalServicePriceService.saveAll(accommodation.getAdditionalServiceWithPrices());
//            itemService.saveAll(accommodation.getPricelist().getItem());
//
//            AccommodationForDatabase adb = new AccommodationForDatabase(accommodation);
//            accommodationRepository.save(adb);
//
//            response.setSuccess(true);
//        }
//        else {
//
//            response.setSuccess(false);      //ako takav smestaj  postoji u bazi
//
//        }
//        return response;
//    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAgentAccommodationsRequest")
    @ResponsePayload
    public GetAgentAccommodationsResponse getAccommodationsByAgentUsername(@RequestPayload GetAgentAccommodationsRequest request) {

        Agent agent = this.agentService.findAgentByUsername(request.getUsername());

        if(agent == null) {
            return null;
        }

        GetAgentAccommodationsResponse response = new GetAgentAccommodationsResponse();
        List<AccommodationForDatabase> accommodationList = this.accommodationRepository.findAccommodationForDatabaseByAgent(agent);

        List<Accommodation> listForSOAP = new ArrayList<>();

        for(AccommodationForDatabase a : accommodationList){
            Accommodation accommodation = new Accommodation(a);
            listForSOAP.add(accommodation);
        }

        response.getAccommodation().addAll(listForSOAP);


        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteRoomRequest")
    @ResponsePayload
    public DeleteRoomResponse deleteRoomFromAccommodation(@RequestPayload DeleteRoomRequest request) {

        DeleteRoomResponse response = new DeleteRoomResponse();

        AccommodationForDatabase accommodationForDatabase = this.accommodationRepository.findAccommodationForDatabaseByName(request.getAccommodationName());
    //    AccommodationForDatabase accByRoom = this.accommodationRepository.findAccommodationForDatabaseByRoom(request.getRoom());

        TRoom room = new TRoom();
        for(TRoom r: accommodationForDatabase.getRoom()){
            if(r.getRoomNumber().equals( request.getRoom().getRoomNumber())) {
                room = this.roomService.findRoomById(r.getId());
                break;
            }
        }

        Date today = new Date();
        //      List<ReservationForDatabase> afterToday = this.reservationService.findReservationForDatabaseByArrivalDateGreaterThanEqual(today);
        List<ReservationForDatabase> allReservations = this.reservationService.findReservationForDatabaseByRoom(room);
        List<ReservationForDatabase> afterToday = this.reservationService.findReservationForDatabaseByArrivalDateGreaterThanEqualAndRoom(today,room);

        if(afterToday.size() == 0){

            for(ReservationForDatabase r: allReservations){
                r.getRoom().remove(room);
                this.reservationService.save(r);
            }

            accommodationForDatabase.getRoom().remove(room);
            accommodationForDatabase.setNumberOfPeopleCapacity(accommodationForDatabase.getNumberOfPeopleCapacity() - room.getCapacity().intValue());
            this.accommodationRepository.save(accommodationForDatabase);

            this.roomService.deleteRoom(room);

            response.setSuccess(true);
            return response;
        }

        response.setSuccess(false);
        return response;
    }


}
