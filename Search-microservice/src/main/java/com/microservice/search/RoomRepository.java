package com.microservice.search;

import com.microservice.search.model.TRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface RoomRepository extends JpaRepository<TRoom, Long> {

    @Query(value = "SELECT t.* from troom t " +
            "left join accommodation_room ar on t.id = ar.room_id " +
            "where ar.accommodation_id = :id and t.id not in (select tt.id from troom tt " +
            "                            left join reservation_room rr on rr.room_id = tt.id " +
            "                            left join reservation res on rr.reservation_id = res.id " +
            "where((:arrivalDate between res.arrival_date and res.departure_date) or " +
            "    (:departureDate between res.arrival_date and res.departure_date)))", nativeQuery = true)
    Set<TRoom> getFreeRoomsByDatesAndAccommodationIdAndNumberOfPersons(
            @Param("id") Long id,
            @Param("arrivalDate") Date arrivalDate,
            @Param("departureDate") Date departureDate
    );

}
