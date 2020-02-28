package com.ftn.agent.repository;

import com.ftn.agent.model.TRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RoomRepository extends JpaRepository<TRoom, Long> {

    TRoom findTRoomById(Long id);
    TRoom findTRoomByAccommodationNameAndRoomNumber(String accName, BigInteger roomNum);
}
