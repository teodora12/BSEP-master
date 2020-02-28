package com.ftn.bsep.controller;

import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import com.ftn.bsep.service.AdditionalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/additional_services")
public class AdditionalServiceController {

    @Autowired
    private AdditionalServiceService service;

    @RequestMapping(value="", method= RequestMethod.GET)
  //  @PreAuthorize("hasAuthority('READ_ADDITIONAL_SERVICES')")
    public ResponseEntity<List<TAdditionalService>> getAdditionalServices() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
 //   @PreAuthorize("hasAuthority('READ_ADDITIONAL_SERVICES')")
    public ResponseEntity<Object> getAdditionalService(@PathVariable Long id) {
        TAdditionalService additionalService = service.findOne(id);
        if (additionalService == null) {
            return new ResponseEntity<>("Additional service not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(additionalService, HttpStatus.OK);
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
 //   @PreAuthorize("hasAuthority('ADD_ADDITIONAL_SERVICES')")
    public ResponseEntity<Object> addAdditionalService(@RequestBody TAdditionalService data) {

        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAdditionalService foundAdditionalService = service.findByName(data.getName());
        if (foundAdditionalService != null) {
            return new ResponseEntity<>("Additional service with this name already exists.", HttpStatus.FORBIDDEN);
        }
        TAdditionalService additionalService = new TAdditionalService();
        additionalService.setName(data.getName());
        return new ResponseEntity<>(service.save(additionalService), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
 //   @PreAuthorize("hasAuthority('UPDATE_ADDITIONAL_SERVICES')")
    public ResponseEntity<Object> updateAdditionalService(@PathVariable Long id, @RequestBody TAdditionalService data){

        TAdditionalService additionalService = service.findOne(id);
        if (additionalService == null) {
            return new ResponseEntity<>("Additional service not found.", HttpStatus.NOT_FOUND);
        }
        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAdditionalService as = service.findByName(data.getName());
        if (as != null && as.getId() != additionalService.getId()) {
            return new ResponseEntity<>("Another additional service with this name already exists.", HttpStatus.FORBIDDEN);
        }
        additionalService.setName(data.getName());
        return new ResponseEntity<>(service.save(additionalService), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  //  @PreAuthorize("hasAuthority('DELETE_ADDITIONAL_SERVICES')")
    public ResponseEntity<Object> deleteAdditionalService(@PathVariable Long id){

        TAdditionalService additionalService = service.findOne(id);
        if (additionalService == null) {
            return new ResponseEntity<>("Additional service not found.", HttpStatus.NOT_FOUND);
        }
        service.delete(additionalService);
        return new ResponseEntity<>(additionalService, HttpStatus.OK);
    }


}
