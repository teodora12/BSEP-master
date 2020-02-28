package com.ftn.bsep.service;


import com.ftn.bsep.dto.accommodation.CreateAndUpdateAccDTO;
import com.ftn.bsep.model.AccommodationForDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationService {

     AccommodationForDatabase newAccommodation(CreateAndUpdateAccDTO newAccommodationDTO);
     AccommodationForDatabase updateAccommodation(CreateAndUpdateAccDTO newAccommodationDTO);
     AccommodationForDatabase findAccommodationById(Long id);

//     List<AccommodationForDatabase> findAccommodations();
    // AccommodationForDatabase findAccommodationById(Long id);

     AccommodationForDatabase save(AccommodationForDatabase accommodationForDatabase);
     AccommodationForDatabase findAccommodationForDatabaseByName(String name);
     void delete(AccommodationForDatabase accommodation);
     List<AccommodationForDatabase> getAll ();
}
