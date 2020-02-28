package com.microservice.search;

import com.microservice.search.model.AccommodationSearchResult;
import com.microservice.search.model.GetFreeRoomByAccommodationDto;
import com.microservice.search.model.TRoom;
import com.microservice.search.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping(value = "/api/search", produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchController {

    @Autowired
    private SearchService searchService;
    @Autowired
    private RoomRepository roomRepository;

    @PostMapping//produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity
    searchAccommodation(@Valid @RequestBody AccommodationSearchDto searchDto) {
        Set  set = this.searchService.search(searchDto);
        if(set == null){
            return new ResponseEntity<>("Fields are not valid!", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(set, HttpStatus.OK);
    }

    @PostMapping(value = "/rooms")
    public ResponseEntity getFreeRooms(@Valid @RequestBody GetFreeRoomByAccommodationDto getRoomsDto) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isLongValid(getRoomsDto.getAccommodationId());
        boolean isnumberOfPersons = regularExpressions.isNumberValid(getRoomsDto.getNumberOfPersons());


        if(!(isIdValid || isnumberOfPersons))
        {
           return new ResponseEntity<>("Fields are not valid!", HttpStatus.FORBIDDEN);
        }

        Set<TRoom> res = this.roomRepository.getFreeRoomsByDatesAndAccommodationIdAndNumberOfPersons(getRoomsDto.getAccommodationId(),
                getRoomsDto.getFromDate(), getRoomsDto.getToDate());
        System.out.println(res);
        return ResponseEntity.ok(res);
    }

}
