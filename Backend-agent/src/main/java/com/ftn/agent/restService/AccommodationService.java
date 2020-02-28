package com.ftn.agent.restService;

import com.ftn.agent.model.TRoom;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationService {

     List<AccommodationForDatabase> findAccommodations();
     AccommodationForDatabase findAccommodationById(Long id);
     List<AccommodationForDatabase> getAccommodationByAgentUsername(String username);
     AccommodationForDatabase findAccommodationByName(String name);
     AccommodationForDatabase save(AccommodationForDatabase accommodation);
     AccommodationForDatabase findAccommodationByRoom(TRoom room);



}
