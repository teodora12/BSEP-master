package com.ftn.agent.controller;

import com.ftn.agent.dto.CreateAndUpdateRoomDTO;
import com.ftn.agent.dto.RegisterDTO;
import com.ftn.agent.model.TRoom;
import com.ftn.agent.model.User;
import com.ftn.agent.repository.UserRepository;
import com.ftn.agent.restService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterDTO registerDTO)  {
        User user = this.userService.register(registerDTO);

        if(user == null){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id)  {
        User user = this.userRepository.findUserById(id);

        if(user == null){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
