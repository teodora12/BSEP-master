package com.microservice.usermanagement.controller;


import com.microservice.usermanagement.model.*;
import com.microservice.usermanagement.service.AgentService;
import com.microservice.usermanagement.service.RoleService;
import com.microservice.usermanagement.service.UserService;
import com.microservice.usermanagement.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping(value="/api/userManagement")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AgentService agentService;



    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/email/{email}", method=RequestMethod.GET)
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(email);
        if(isEmailValid == false){
            return new ResponseEntity<>("Email is not valid", HttpStatus.FORBIDDEN);

        }

        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{email}", method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable String email) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(email);
        if(isEmailValid == false){
            return new ResponseEntity<>("Email is not valid", HttpStatus.FORBIDDEN);

        }

        User user = userService.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
        userService.delete(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="/activate-user/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> activateUser(@PathVariable Long id) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isNumberValid(id);
        if(isIdValid == false){
            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
        }

        User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
        user.setEnabled(true);
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @RequestMapping(value="/block-user/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> blockUser(@PathVariable Long id) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isNumberValid(id);
        if(isIdValid == false){
            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
        }

        User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
        user.setEnabled(false);
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @RequestMapping(value="/save/{email}/{company}", method=RequestMethod.PUT)
    public ResponseEntity<Object> saveUser(@PathVariable String email, @PathVariable int company) {

//        RegularExpressions regularExpressions = new RegularExpressions();
//        boolean isIdValid = regularExpressions.isNumberValid(id);
//        if(isIdValid == false){
//            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
//        }

//        Role r=roleService.findByName("ROLE_AGENT");
//        List<Role> roles = new ArrayList<>();
//        roles.add(r);
//
//        User user = userService.findByEmail(email);
//        if (user == null) {
//            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
//        }
//
//        user.setRoles(roles);
//        userService.save(user);

        Agent a = agentService.findByEmail(email);
        a.setAccepted(true);
        a.setCompanyNumber(company);
//        a.setEmail(user.getEmail());
//        a.setSurname(user.getLastName());
//        a.setName(user.getName());
//        a.setPassword(user.getPassword());
//        a.setAddress(user.getAddress());
//        a.setUsername(user.getUsername());

        agentService.save(a);

        return new ResponseEntity<>( HttpStatus.OK);
    }


}
