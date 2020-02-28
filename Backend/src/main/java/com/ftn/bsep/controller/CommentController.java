package com.ftn.bsep.controller;

import com.ftn.bsep.dto.user.BasicUserDto;
import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.CommentForDatabase;

import com.ftn.bsep.model.User;
import com.ftn.bsep.model.modelGenerated.Accommodation;
import com.ftn.bsep.repository.AccommodationRepository;
import com.ftn.bsep.repository.ReservationRepository;
import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.service.CommentService;
import com.ftn.bsep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ftn.bsep.service.UtilityService;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository repository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    AccommodationRepository accommodationRepository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<List<CommentForDatabase>> getComments() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/approved", method=RequestMethod.GET)
    public ResponseEntity<List<CommentForDatabase>> getApprovedComments() {
        return new ResponseEntity<>(service.findApprovedComments(), HttpStatus.OK);
    }

    @RequestMapping(value="/waiting", method=RequestMethod.GET)
    public ResponseEntity<List<CommentForDatabase>> getWaitingComments() {
        return new ResponseEntity<>(service.findWaitingComments(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> getComment(@PathVariable Long id) {
        CommentForDatabase comment = service.findOne(id);
        if (comment == null) {
            return new ResponseEntity<>("Comment not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @RequestMapping(value="/apartment/{id}", method=RequestMethod.GET)
    public List<CommentForDatabase> getAllCommentsForApartment(@PathVariable Long id) {
        return service.findApartmentComments(id);
    }

    @RequestMapping(value="/apartment/{id}/approved", method=RequestMethod.GET)
    public List<CommentForDatabase> getAllApprovedCommentsForApartment(@PathVariable Long id) {
        return service.findApartmentApprovedComments(id);
    }


    //TODO PRISTUP SAMO ADMINU
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteComment(@PathVariable Long id) {


        for(AccommodationForDatabase a: accommodationRepository.findAll()){
            for(CommentForDatabase c: a.getComments()){
                if(c.getId()==id){
                    a.getComments().remove(c);
                  accommodationRepository.save(a);
                    service.delete(c);
                }

            }
        }

//        CommentForDatabase comment = service.findOne(id);
//
//        if (comment == null) {
//            return new ResponseEntity<>("Comment not found.", HttpStatus.NOT_FOUND);
//        }
//        service.delete(comment);
        return new ResponseEntity<>( HttpStatus.OK);

    }

    @RequestMapping(value="/{id}/approve", method=RequestMethod.PUT)
    public ResponseEntity<Object> approveComment(@PathVariable Long id){

        CommentForDatabase comment = service.findOne(id);

        if (comment == null) {
            return new ResponseEntity<>("Comment not found.", HttpStatus.NOT_FOUND);
        }
        comment.setStatus("approved");
        return new ResponseEntity<>(service.save(comment), HttpStatus.OK);

    }

    @RequestMapping(value="/{id}/addComment", method=RequestMethod.POST)
    public ResponseEntity<Object> addComment(@PathVariable Long id,@RequestBody CommentForDatabase data, @RequestHeader(value="Authorization") String authorization) {


        User user=repository.findUserByEmail(UtilityService.getEmailFromToken(authorization));
        data.setUser(user);


        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormatter.format(new Date());
        String time = timeFormatter.format(new Date());



        return new ResponseEntity<>( HttpStatus.OK);
    }



}