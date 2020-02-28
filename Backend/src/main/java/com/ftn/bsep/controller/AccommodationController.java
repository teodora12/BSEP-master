package com.ftn.bsep.controller;

import com.ftn.bsep.dto.accommodation.*;
import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.modelGenerated.Item;
import com.ftn.bsep.model.modelGenerated.Pricelist;
import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import com.ftn.bsep.repository.AccommodationRepository;
import com.ftn.bsep.repository.ItemRepository;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.AccommodationService;
import com.ftn.bsep.service.ItemService;
import com.ftn.bsep.service.PricelistService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/api/accommodation", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccommodationController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SEARCH_SERVICE_URI= "https://localhost:8082/api/search";

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private AccommodationRepository accommodationRepository;


    @PostMapping(value = "/search")
    public ResponseEntity searchAccommodation(@RequestBody SearchAccommodation searchDto) {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity requestEntity = new HttpEntity<>(searchDto, requestHeaders);

        ResponseEntity resp = restTemplate.exchange(SEARCH_SERVICE_URI, HttpMethod.POST,requestEntity, AccommodationDto[].class);
        return new ResponseEntity(resp.getBody(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AccommodationForDatabase> newAccommodation(@Valid @RequestBody CreateAndUpdateAccDTO newAccommodationDTO)  {



        AccommodationForDatabase accommodationForDatabase = this.accommodationService.newAccommodation(newAccommodationDTO);
        if(accommodationForDatabase == null){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodationForDatabase, HttpStatus.OK);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<AccommodationForDatabase> updateAccommodation(@Valid @RequestBody CreateAndUpdateAccDTO newAccommodationDTO)  {

        AccommodationForDatabase accommodation = this.accommodationService.updateAccommodation(newAccommodationDTO);
        if(accommodation == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodation, HttpStatus.OK);
    }

    @PostMapping(value= "/pictures")
    public ResponseEntity getPicturesForAccommodations(@RequestBody List<AccommodationIdPictureDto> accommodationIdPictureDtos) {

        List<AccommodationIdPictureBytesDto> result = new ArrayList<>();
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/images/");
        for (AccommodationIdPictureDto accommodationIdPictureDto : accommodationIdPictureDtos) {

            AccommodationIdPictureBytesDto temp = new AccommodationIdPictureBytesDto();
            temp.setId(accommodationIdPictureDto.getId());
            temp.setPicture(new ArrayList<>());

            for (String picture : accommodationIdPictureDto.getPicture()) {
                File in = new File(filePath + picture);
                try {
                    temp.getPicture().add(IOUtils.toByteArray(new FileInputStream(in)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            result.add(temp);

        }
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/items/{id}")
    public ResponseEntity getAccommodationByIdd(@PathVariable Long id) {

      Item items= this.itemService.findById(id);
        return new ResponseEntity(items, HttpStatus.OK);
    }


    // Sa ucitanom slikom
    @GetMapping(value = "/{id}")
    public ResponseEntity getAccommodationById(@PathVariable Long id )  {

        AccommodationForDatabase accommodationFromDb = this.accommodationService.findAccommodationById(id);
        if(accommodationFromDb == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        AccommodationWithBytePictures accommodation = new AccommodationWithBytePictures(accommodationFromDb);
        accommodation.setPicture(new ArrayList<>());
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/images/");
        for (String picture : accommodationFromDb.getPicture()) {

            File in = new File(filePath + picture);
            try {
                accommodation.getPicture().add(IOUtils.toByteArray(new FileInputStream(in)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(accommodation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccommodationForDatabase>> getAll(  )  {

        List<AccommodationForDatabase> accommodations = this.accommodationService.getAll();
        if(accommodations == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accommodations, HttpStatus.OK);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    //  @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

       AccommodationForDatabase accommodation = this.accommodationService.findAccommodationById(id);
        if (accommodation == null) {
            return new ResponseEntity<>("Category not found.", HttpStatus.NOT_FOUND);
        }

        this.accommodationService.delete(accommodation);
        return new ResponseEntity<>(accommodation, HttpStatus.OK);

    }



    @Transactional
    @RequestMapping(value="/deleteItem/{id}", method=RequestMethod.DELETE)
    //  @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    public ResponseEntity<Object> deleteItem(@PathVariable Long id) {


      //  this.itemService.removeItem(id);
        Item item = this.itemService.findById(id);
        this.itemService.delete(item);

        return new ResponseEntity<>( HttpStatus.OK);

    }

    @PutMapping(value = "/editItems")
    public ResponseEntity<Item> updateAccommodation(@RequestBody Item i)  {

       Item item = this.itemService.findById(i.getId());
       item.setEndDatePeriod(i.getEndDatePeriod());
       item.setStartDatePeriod(i.getStartDatePeriod());
       item.setCapacity(i.getCapacity());
       item.setPrice(i.getPrice());
       this.itemRepository.save(item);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }



}
