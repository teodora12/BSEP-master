package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.dto.CreateAndUpdateRoomDTO;
import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import com.ftn.agent.repository.AccommodationRepository;
import com.ftn.agent.repository.RoomRepository;
import com.ftn.agent.restService.AccommodationService;
import com.ftn.agent.restService.ReservationService;
import com.ftn.agent.restService.RoomService;
import com.ftn.agent.security.validation.RegularExpressions;
import com.ftn.agent.soapService.SOAPConnectorAccommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    AccommodationService accommodationService;


    @Autowired
    RoomRepository roomRepository;

    @Autowired
    private SOAPConnectorAccommodation soapConnectorAccommodation;

    @Autowired
    ReservationService reservationService;


    @Override
    public TRoom createRoom(CreateAndUpdateRoomDTO roomDTO){

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isRoomNumberValid = regularExpressions.isNumberValid(roomDTO.getRoomNumber().toString());
        boolean isCapacityValid = regularExpressions.isNumberValid(roomDTO.getCapacity().toString());
        boolean isFloorValid = regularExpressions.isNumberValid(roomDTO.getFloor().toString());

        if(!(isRoomNumberValid && isCapacityValid && isFloorValid)){
            return null;
        }

        TRoom room = new TRoom(roomDTO);

     //   Accommodation accommodation = this.accommodationService.findAccommodationByName(roomDTO.getAccommodationName());
        AccommodationForDatabase accommodationForDatabase = this.accommodationService.findAccommodationByName(roomDTO.getAccommodationName());
        CreateRoomResponse response = this.soapConnectorAccommodation.createRoom(roomDTO.getAccommodationName(),room);

        if(response.isSucess() != false) {


            accommodationForDatabase.getRoom().add(room);

            this.roomRepository.save(room);
            this.accommodationService.save(accommodationForDatabase);

            return room;
        }

        return null;

    }

    @Override
    public TRoom updateRoom(CreateAndUpdateRoomDTO roomDTO) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isNewRoomNumberValid = regularExpressions.isNumberValid(roomDTO.getNewRoomNumber().toString());
        boolean isCapacityValid = regularExpressions.isNumberValid(roomDTO.getCapacity().toString());
        boolean isFloorValid = regularExpressions.isNumberValid(roomDTO.getFloor().toString());

        if(!(isNewRoomNumberValid && isCapacityValid && isFloorValid)){
            return null;
        }


        TRoom room = this.roomRepository.findTRoomById(roomDTO.getRoomId());

        room.setCapacity(roomDTO.getCapacity());
        room.setFloor(roomDTO.getFloor());
        room.setRoomNumber(roomDTO.getNewRoomNumber());

        UpdateRoomResponse response = this.soapConnectorAccommodation.updateRoom(room.getAccommodationName(),room, roomDTO.getRoomNumber());

        if(response.isSuccess() != false) {

            room.setCapacity(roomDTO.getCapacity());
            room.setFloor(roomDTO.getFloor());
            room.setRoomNumber(roomDTO.getNewRoomNumber());
            this.roomRepository.save(room);

            return room;
        }
       return null;
    }

    @Override
    public TRoom findRoomById(Long id) {
        return this.roomRepository.findTRoomById(id);
    }

    @Override
    public List<TRoom> saveAll(List<TRoom> rooms) {
        return this.roomRepository.saveAll(rooms);
    }

    @Override
    public boolean deleteRoom(Long id) {

        TRoom room = this.roomRepository.findTRoomById(id);
        //Accommodation accommodation = this.accommodationService.findAccommodationByRoom(room);
        AccommodationForDatabase accommodationForDatabase = this.accommodationService.findAccommodationByRoom(room);
        if(accommodationForDatabase == null){
            return false;
        }

        Date today = new Date();

        List<Reservation> allReservations = this.reservationService.getReservationsByRoom(room);
////        List<Reservation> afterToday = this.reservationService.findReservationsByArrivalDateGreaterThanEqual(today);
//        List<Reservation> afterToday = this.reservationService.findReservationsByArrivalDateGreaterThanEqualAndRoom(today,room);
//
//        if (afterToday.size() == 0) {

            DeleteRoomResponse response = this.soapConnectorAccommodation.deleteRoom(room,accommodationForDatabase.getName());

           if(response.isSuccess() == true) {

              for(Reservation r: allReservations){
                  r.getRoom().remove(room);
              }

              accommodationForDatabase.getRoom().remove(room);
              this.roomRepository.delete(room);
              return true;
           }

 //       }

        return false;
    }

    @Override
    public TRoom findRoomByAccNameAndRoomNumber(String accName, BigInteger roomNum) {
        return this.roomRepository.findTRoomByAccommodationNameAndRoomNumber(accName,roomNum);
    }


}
