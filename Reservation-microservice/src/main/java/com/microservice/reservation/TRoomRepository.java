package com.microservice.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TRoomRepository extends JpaRepository<TRoom, Long> {

    TRoom findTRoomById(Long id);
}
