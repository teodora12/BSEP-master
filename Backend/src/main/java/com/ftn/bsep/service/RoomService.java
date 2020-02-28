package com.ftn.bsep.service;


import com.ftn.bsep.model.modelGenerated.TRoom;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.math.BigInteger;
import java.util.List;

@Service
public interface RoomService {

     TRoom save(TRoom tRoom);
     List<TRoom> findRoomsByRoomNumber(BigInteger roomNumber);
     List<TRoom> findRoomsByRoomNumberAndAccName(BigInteger roomNum, String accName);
     TRoom findRoomById(Long id);
     void deleteRoom(TRoom room);
}
