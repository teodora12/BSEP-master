package com.microservice.search;

import com.microservice.search.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface SearchRepository extends JpaRepository<Accommodation, Long> {

    @Query(value = "SELECT a.*, a.number_of_people_capacity - ifnull(sum(troom.capacity), 0) left_space FROM accommodation a " +
            "left join address adr on adr.id = a.address_id " +
            "left join tcancellation canc on a.cancellation_id = canc.id " +
            "left join accommodation_room ar on a.id = ar.accommodation_id " +
            "left join reservation_room rr on rr.room_id = ar.room_id " +
            "left join reservation r on rr.reservation_id = r.id " +
            "left join troom on rr.room_id = troom.id " +
            "WHERE (adr.city like CONCAT('%',:town,'%') and adr.country like CONCAT('%',:country,'%')) and " +
            "(isnull(:accommodationCategory) or a.accommodation_category_id = :accommodationCategoryId ) and " +
            "(isnull(:accommodationType) or a.accommodation_type_id = :accommodationTypeId) and " +
            "r.id in (select res.id from reservation res where((:arrivalDate between res.arrival_date and res.departure_date) or (:departureDate between res.arrival_date and res.departure_date))) " +
            "group by a.id " +
            "having left_space >= :numberOfPeople " +
            "union " +
            "SELECT a.*, a.number_of_people_capacity - ifnull(sum(troom.capacity), 0) left_space FROM accommodation a " +
            "left join address adr on adr.id = a.address_id " +
            "left join tcancellation canc on a.cancellation_id = canc.id " +
            "left join accommodation_room ar on a.id = ar.accommodation_id " +
            "left join reservation_room rr on rr.room_id = ar.room_id " +
            "left join reservation r on rr.reservation_id = r.id " +
            "left join troom on rr.room_id = troom.id " +
            "WHERE (adr.city like CONCAT('%',:town,'%') and adr.country like CONCAT('%',:country,'%')) and " +
            "(isnull(:accommodationCategory) or a.accommodation_category_id = :accommodationCategoryId ) and " +
            "(isnull(:accommodationType) or a.accommodation_type_id = :accommodationTypeId)  " +
            "group by a.id " +
            "having left_space >= :numberOfPeople ",
    nativeQuery = true)
    Set<Accommodation> searchTemp(@Param("country") String country,
                                  @Param("town") String town,
                                  @Param("accommodationCategoryId") long accommodationCategoryId,
                                  @Param("accommodationCategory") TAccommodationCategory accommodationCategory,
                                  @Param("accommodationTypeId") long accommodationTypeId,
                                  @Param("accommodationType") TAccommodationType accommodationType,
                                  @Param("arrivalDate") Date arrivalDate,
                                  @Param("departureDate") Date departureDate,
                                  @Param("numberOfPeople") int numberOfPeople
        );



    @Query(value = "SELECT t.* from accommodation a " +
            "left join accommodation_room ar on a.id = ar.accommodation_id " +
            "left join troom t on ar.room_id = t.id " +
            "where a.id = :id and t.id not in (select tt.id from troom tt " +
            "                            left join reservation_room rr on rr.room_id = tt.id " +
            "                            left join reservation res on rr.reservation_id = res.id " +
            "where((:arrivalDate between res.arrival_date and res.departure_date) or " +
            "    (:departureDate between res.arrival_date and res.departure_date)))",
            nativeQuery = true)
    Set<TRoom> getFreeRoomsByDatesAndAccommodationIdAndNumberOfPersons(
                                  @Param("id") Long id,
                                  @Param("arrivalDate") Date arrivalDate,
                                  @Param("departureDate") Date departureDate
    );

}
