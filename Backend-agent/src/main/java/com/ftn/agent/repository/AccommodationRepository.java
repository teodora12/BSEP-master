package com.ftn.agent.repository;

import com.ftn.agent.model.Accommodation;
import com.ftn.agent.model.TRoom;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository  extends JpaRepository<AccommodationForDatabase, Long> {

    AccommodationForDatabase findAccommodationForDatabaseById(Long id);
    AccommodationForDatabase findAccommodationForDatabaseByName(String name);
    AccommodationForDatabase findAccommodationForDatabaseByRoom(TRoom room);

}
