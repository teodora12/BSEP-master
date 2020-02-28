package com.ftn.agent.controller;

import com.ftn.agent.dto.CreateAndUpdateRoomDTO;
import com.ftn.agent.model.TRoom;
import com.ftn.agent.restService.AccommodationService;
import com.ftn.agent.restService.RoomService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping(value = "/get/{id}")
    @PreAuthorize("hasAuthority('GET_ROOM')")
    public ResponseEntity<TRoom> getRoomById(@PathVariable Long id){
        TRoom room =this.roomService.findRoomById(id);
        if(room == null){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room,HttpStatus.OK);

    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('ADD_ROOM')")
    public ResponseEntity<CreateAndUpdateRoomDTO> newRoom(@Valid @RequestBody CreateAndUpdateRoomDTO roomDTO)  {
        TRoom room = this.roomService.createRoom(roomDTO);

        if(room == null){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CreateAndUpdateRoomDTO(room),HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @PreAuthorize("hasAuthority('UPDATE_ROOM')")
    public ResponseEntity<CreateAndUpdateRoomDTO> updateRoom(@Valid @RequestBody CreateAndUpdateRoomDTO roomDTO){

        TRoom room = this.roomService.updateRoom(roomDTO);
        if(room == null){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CreateAndUpdateRoomDTO(room),HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE_ROOM')")
    public ResponseEntity<Boolean> deleteRoom(@Valid @PathVariable Long id){

        Boolean success = this.roomService.deleteRoom(id);
        if(success != true){
            return new  ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }


}
