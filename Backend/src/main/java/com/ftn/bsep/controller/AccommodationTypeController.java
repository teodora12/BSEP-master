package com.ftn.bsep.controller;


import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import com.ftn.bsep.service.AccommodationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accommodationTypes")
public class AccommodationTypeController {


    @Autowired
    private AccommodationTypeService service;


    @RequestMapping(value="", method= RequestMethod.GET)
   // @PreAuthorize("hasAuthority('READ_TYPES')")
    public ResponseEntity<List<TAccommodationType>> getTypes() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
  //  @PreAuthorize("hasAuthority('READ_TYPES')")
    public ResponseEntity<Object> getType(@PathVariable Long id) {
        TAccommodationType type = service.findOne(id);
        if (type == null) {
            return new ResponseEntity<>("Accommodation type not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(type, HttpStatus.OK);
    }


    @RequestMapping(value="/add", method=RequestMethod.POST)
  //  @PreAuthorize("hasAuthority('ADD_TYPE')")
    public ResponseEntity<Object> addAccommodationType(@RequestBody TAccommodationType data){

        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAccommodationType t = service.findByTypeName(data.getName());
        if (t != null) {
            return new ResponseEntity<>("Type with this name already exists.", HttpStatus.FORBIDDEN);
        }
        TAccommodationType type = new TAccommodationType();
        type.setName(data.getName());
        return new ResponseEntity<>(service.save(type), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
   // @PreAuthorize("hasAuthority('UPDATE_TYPE')")
    public ResponseEntity<Object> updateAccommodationType(@PathVariable Long id, @RequestBody TAccommodationType data) {

        TAccommodationType type = service.findOne(id);
        if (type == null) {
            return new ResponseEntity<>("Accommodation type not found.", HttpStatus.NOT_FOUND);
        }
        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAccommodationType t = service.findByTypeName(data.getName());
        if (t != null && t.getId() != type.getId()) {
            return new ResponseEntity<>("Another type with this name already exists.", HttpStatus.FORBIDDEN);
        }
        type.setName(data.getName());
        return new ResponseEntity<>(service.save(type), HttpStatus.OK);
    }



    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  //  @PreAuthorize("hasAuthority('DELETE_TYPE')")
    public ResponseEntity<Object> deleteAccommodationType(@PathVariable Long id){

        TAccommodationType type = service.findOne(id);
        if (type == null) {
            return new ResponseEntity<>("Accommodation type not found.", HttpStatus.NOT_FOUND);
        }
        service.delete(type);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }
}
