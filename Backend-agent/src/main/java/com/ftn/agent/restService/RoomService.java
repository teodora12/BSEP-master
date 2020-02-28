package com.ftn.agent.restService;

import com.ftn.agent.dto.CreateAndUpdateRoomDTO;
import com.ftn.agent.model.TRoom;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.math.BigInteger;
import java.util.List;

@Service
public interface RoomService {

    public TRoom createRoom(CreateAndUpdateRoomDTO roomDTO);
    public TRoom updateRoom(CreateAndUpdateRoomDTO roomDTO);
    TRoom findRoomById(Long id);
    List<TRoom> saveAll(List<TRoom> rooms);
    boolean deleteRoom(Long id);
    TRoom findRoomByAccNameAndRoomNumber(String accName, BigInteger roomNum);
}
