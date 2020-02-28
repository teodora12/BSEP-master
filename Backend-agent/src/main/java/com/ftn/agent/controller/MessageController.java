package com.ftn.agent.controller;

import com.ftn.agent.dto.CreateMessageDTO;
import com.ftn.agent.dto.MessageDTO;
import com.ftn.agent.model.Message;
import com.ftn.agent.model.forDatabase.MessageForDatabase;
import com.ftn.agent.restService.MessageService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('SENT_MESSAGE')")
    public ResponseEntity<Boolean> sendMessage(@Valid @RequestBody CreateMessageDTO messageDTO){


        MessageForDatabase message = this.messageService.sendMessage(messageDTO);

        if(message == null){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping(value = "/all/{username}")
    @PreAuthorize("hasAuthority('ALL_MESSAGES')")
    public ResponseEntity<List<MessageDTO>> getAllMessages(@PathVariable String username){

        List<MessageForDatabase> messages = this.messageService.getAllMessages(username);

        if(messages == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

            List<MessageDTO> dtos = new ArrayList<>();
            for(MessageForDatabase m: messages){
                MessageDTO dto = new MessageDTO(m);
                dtos.add(dto);
            }





        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }



}
