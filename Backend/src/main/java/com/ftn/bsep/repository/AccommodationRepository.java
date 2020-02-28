package com.ftn.bsep.repository;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.modelGenerated.Accommodation;
import com.ftn.bsep.model.modelGenerated.Agent;
import com.ftn.bsep.model.modelGenerated.TRoom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationForDatabase, Long> {

    List<AccommodationForDatabase> findAccommodationsByAgent_Id(Long id);

    List<AccommodationForDatabase> findAccommodationForDatabaseByAgent(Agent agent);
    AccommodationForDatabase findAccommodationForDatabaseByName(String name);
    AccommodationForDatabase findAccommodationForDatabaseById(Long id);
    AccommodationForDatabase findAccommodationForDatabaseByRoom(TRoom room);
}
