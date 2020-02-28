package com.ftn.bsep.controller;


import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.AccommodationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories")
public class AccommodationCategoryController {

    @Autowired
    private AccommodationCategoryService service;

//    @CrossOrigin(origins = "*")
    @RequestMapping(value="", method= RequestMethod.GET)
  //  @PreAuthorize("hasAuthority('READ_CATEGORY')")
    public ResponseEntity<List<TAccommodationCategory>> getCategories() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
//    @PreAuthorize("hasAuthority('READ_CATEGORY')")
    public ResponseEntity<Object> getCategory(@PathVariable Long id) {
        TAccommodationCategory category = service.findOne(id);
        if (category == null) {
            return new ResponseEntity<>("Accommodation category not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }



    @RequestMapping(value="/add", method=RequestMethod.POST)
 //   @PreAuthorize("hasAuthority('ADD_CATEGORY')")
    public ResponseEntity<Object> addAccommodationCategory(@RequestBody TAccommodationCategory data) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isNameValid = regularExpressions.isAccCategoryValid(data.getName());
         if(isNameValid == false){
             return new ResponseEntity<>("Category name is not valid!", HttpStatus.FORBIDDEN);
         }

        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAccommodationCategory c = service.findByName(data.getName());
        if (c != null) {
            return new ResponseEntity<>("Category with this name already exists.", HttpStatus.FORBIDDEN);
        }
        TAccommodationCategory category = new TAccommodationCategory();
        category.setName(data.getName());
        return new ResponseEntity<>(service.save(category), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
 //   @PreAuthorize("hasAuthority('UPDATE_CATEGORY')")
    public ResponseEntity<Object> updateAccommodationCategory(@PathVariable Long id, @RequestBody TAccommodationCategory data) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isNameValid = regularExpressions.isAccCategoryValid(data.getName());
        if(isNameValid == false){
            return new ResponseEntity<>("Category name is not valid!", HttpStatus.FORBIDDEN);
        }

        TAccommodationCategory category = service.findOne(id);
        if (category == null) {
            return new ResponseEntity<>("Category not found.", HttpStatus.NOT_FOUND);
        }
        if (data.getName() == null || data.getName() == "") {
            return new ResponseEntity<>("Name field is required.", HttpStatus.FORBIDDEN);
        }
        TAccommodationCategory c = service.findByName(data.getName());
        if (c != null && c.getId() != category.getId()) {
            return new ResponseEntity<>("Another category with this name already exists.", HttpStatus.FORBIDDEN);
        }
        category.setName(data.getName());
        return new ResponseEntity<>(service.save(category), HttpStatus.OK);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  //  @PreAuthorize("hasAuthority('DELETE_CATEGORY')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        TAccommodationCategory category = service.findOne(id);
        if (category == null) {
            return new ResponseEntity<>("Category not found.", HttpStatus.NOT_FOUND);
        }

        service.delete(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

