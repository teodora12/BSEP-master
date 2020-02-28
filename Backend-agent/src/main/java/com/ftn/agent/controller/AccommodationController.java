package com.ftn.agent.controller;


import com.ftn.agent.dto.AccommodationDTO;
import com.ftn.agent.dto.AgentDTO;
import com.ftn.agent.dto.CreateAndUpdateAccDTO;
import com.ftn.agent.model.Accommodation;
import com.ftn.agent.model.Reservation;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import com.ftn.agent.restService.AccommodationService;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/api/accommodation")
public class AccommodationController {


    @Autowired
    private AccommodationService accommodationService;


    @GetMapping(value ="/{id}")
    @PreAuthorize("hasAuthority('GET_ACCOMMODATION')")
    public ResponseEntity<AccommodationDTO> getAccommodationById(@PathVariable Long id)
    {
      AccommodationForDatabase accommodation = accommodationService.findAccommodationById(id);
      if(accommodation == null){
          return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      AccommodationDTO dto = new AccommodationDTO(accommodation);

      return new ResponseEntity<>(dto,HttpStatus.OK);
    }



    @GetMapping
    @PreAuthorize("hasAuthority('ALL_ACCOMMODATIONS')")
    public ResponseEntity<List<CreateAndUpdateAccDTO>> getAllAccommodations()  {

        List<AccommodationForDatabase> accommodations = this.accommodationService.findAccommodations();
        if(accommodations == null){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        List<CreateAndUpdateAccDTO> dtosList = new ArrayList<>();
        for(AccommodationForDatabase ac: accommodations){
            CreateAndUpdateAccDTO dto = new CreateAndUpdateAccDTO(ac);
            dtosList.add(dto);
        }
        return new ResponseEntity<>(dtosList, HttpStatus.OK);
    }

    @GetMapping(value = "/agent/{username}")
    @PreAuthorize("hasAuthority('ALL_ACCOMMODATIONS')")
    public ResponseEntity<List<AccommodationDTO>> getAccommodationByAgentUsername(@PathVariable String username){
        List<AccommodationForDatabase> accommodations = this.accommodationService.getAccommodationByAgentUsername(username);
        if(accommodations == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        List<AccommodationDTO> dtos = new ArrayList<>();
        for(AccommodationForDatabase ac: accommodations ){
            AccommodationDTO dto = new AccommodationDTO(ac);
            dtos.add(dto);
        }


            return new ResponseEntity<>(dtos,HttpStatus.OK);
    }


}
