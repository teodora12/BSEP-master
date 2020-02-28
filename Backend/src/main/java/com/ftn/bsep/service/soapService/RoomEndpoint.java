package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.AccommodationForDatabase;

import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.service.AccommodationService;
import com.ftn.bsep.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class RoomEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/accommodation";

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private RoomService roomService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateRoomRequest")
    @ResponsePayload
    public CreateRoomResponse createRoom(@RequestPayload CreateRoomRequest request) {


        CreateRoomResponse response = new CreateRoomResponse();

        AccommodationForDatabase accommodationForDatabase = this.accommodationService.findAccommodationForDatabaseByName(request.getAccommodationName());

        if(accommodationForDatabase != null) {
            if ((accommodationForDatabase.getRoom().size() + 1) <= accommodationForDatabase.getCapacity()) {

          //      for(TRoom room: accommodationForDatabase.getRoom()) {
                    List<TRoom> roomList = this.roomService.findRoomsByRoomNumberAndAccName(request.getRoom().getRoomNumber(), request.getRoom().getAccommodationName());
                    int number = roomList.size();
                    if (number != 0) {
                        response.setSucess(false);
                        return response;
                    }
           //     }

                TRoom room = new TRoom();
                room.setCapacity(request.getRoom().getCapacity());
                room.setFloor(request.getRoom().getFloor());
                room.setRoomNumber(request.getRoom().getRoomNumber());
                room.setAccommodationName(request.getRoom().getAccommodationName());

                accommodationForDatabase.getRoom().add(room);
                accommodationForDatabase.setCapacity(accommodationForDatabase.getCapacity() + 1);
                accommodationForDatabase.setNumberOfPeopleCapacity(accommodationForDatabase.getNumberOfPeopleCapacity() + room.getCapacity().intValue());

                this.roomService.save(room);
                this.accommodationService.save(accommodationForDatabase);

                response.setSucess(true);
                return response;

            }
        }
        response.setSucess(false);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateRoomRequest")
    @ResponsePayload
    public UpdateRoomResponse updateRoom(@RequestPayload UpdateRoomRequest request) {


        AccommodationForDatabase accommodationForDatabase = this.accommodationService.findAccommodationForDatabaseByName(request.getAccommodationName());
        List<TRoom> roomsByNumber = this.roomService.findRoomsByRoomNumber(request.getOldRoomNumber());

        UpdateRoomResponse response = new UpdateRoomResponse();

        List<TRoom> roomsById = new ArrayList<>();
        for(TRoom r: roomsByNumber){
            TRoom room = this.roomService.findRoomById(r.getId());
            if(room != null){
                roomsById.add(r);
            }
        }

        TRoom foundedRoom = new TRoom();
        for(TRoom r: accommodationForDatabase.getRoom()){
            for (TRoom ro: roomsById){
                Long id = r.getId();
                if(id.equals(ro.getId())){
                    foundedRoom = this.roomService.findRoomById(r.getId());
                    break;
                }
            }
            break;
        }

           if(foundedRoom == null) {
               response.setSuccess(false);
               return response;
           }

    //    for(TRoom room: accommodationForDatabase.getRoom()) {
            List<TRoom> roomList = this.roomService.findRoomsByRoomNumberAndAccName(request.getRoom().getRoomNumber(), request.getRoom().getAccommodationName());
            int number = roomList.size();
            if (number != 0) {
                response.setSuccess(false);
                return response;
            }
    //    }
            foundedRoom.setRoomNumber(request.getRoom().getRoomNumber());
            foundedRoom.setFloor(request.getRoom().getFloor());
            foundedRoom.setCapacity(request.getRoom().getCapacity());

            this.roomService.save(foundedRoom);

            response.setSuccess(true);



        return response;

    }




}
