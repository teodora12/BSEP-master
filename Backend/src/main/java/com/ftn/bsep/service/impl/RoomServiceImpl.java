package com.ftn.bsep.service.impl;


import com.ftn.bsep.model.modelGenerated.TRoom;
import com.ftn.bsep.repository.AccommodationRepository;
import com.ftn.bsep.repository.RoomRepository;
import com.ftn.bsep.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    RoomRepository roomRepository;


    @Override
    public TRoom save(TRoom tRoom) {

        return roomRepository.save(tRoom);
    }

    @Override
    public List<TRoom> findRoomsByRoomNumber(BigInteger roomNumber) {
        return this.roomRepository.findTRoomsByRoomNumber(roomNumber);
    }

    @Override
    public List<TRoom> findRoomsByRoomNumberAndAccName(BigInteger roomNum, String accName) {
        return this.roomRepository.findTRoomsByRoomNumberAndAccommodationName(roomNum,accName);
    }

    @Override
    public TRoom findRoomById(Long id) {
        return this.roomRepository.findTRoomById(id);
    }

    @Override
    public void deleteRoom(TRoom room) {
        this.roomRepository.delete(room);
    }
}
