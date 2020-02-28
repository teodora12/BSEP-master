package com.ftn.bsep.repository;


import com.ftn.bsep.model.modelGenerated.TRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;

@Repository
public interface RoomRepository extends JpaRepository<TRoom, Long> {

    TRoom findTRoomById(Long id);
    List<TRoom> findTRoomsByRoomNumber(BigInteger roomNumber);
    List<TRoom> findTRoomsByRoomNumberAndAccommodationName(BigInteger roomNum, String accName);

}
