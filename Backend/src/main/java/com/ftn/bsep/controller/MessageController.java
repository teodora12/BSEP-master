package com.ftn.bsep.controller;

import com.ftn.bsep.dto.message.CreateMessageDTO;
import com.ftn.bsep.dto.message.NewMessageWithAccommodationId;
import com.ftn.bsep.model.MessageForDatabase;
import com.ftn.bsep.model.User;
import com.ftn.bsep.model.modelGenerated.Agent;
import com.ftn.bsep.repository.AgentRepository;
import com.ftn.bsep.service.MessageService;
import com.ftn.bsep.service.UserService;
import com.ftn.bsep.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity newMessageFromClient(@Valid @RequestBody NewMessageWithAccommodationId messageDTO,
                                               @RequestHeader(value = "Authorization") String authorization){

        List<Agent> agents = this.agentRepository.findAgentsByAccommodation(messageDTO.getAccommodationId());
        if (agents.isEmpty()) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }

        CreateMessageDTO createMessageDTO = new CreateMessageDTO(messageDTO.getSubject(), messageDTO.getContent(),
                (new Date()).toString(), agents.get(0).getEmail(), UtilityService.getEmailFromToken(authorization));

        MessageForDatabase messageForDatabase = this.messageService.sendMessage(createMessageDTO);

        if(messageForDatabase == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<MessageForDatabase> sendMessage(@Valid @RequestBody CreateMessageDTO messageDTO){

        MessageForDatabase messageForDatabase = this.messageService.sendMessage(messageDTO);

        if(messageForDatabase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(messageForDatabase,HttpStatus.OK);
    }

    @GetMapping(value = "getAll/{username}")
    public ResponseEntity<List<CreateMessageDTO>> getAllMessages(@PathVariable String username){

        List<MessageForDatabase> messagesForDatabase = this.messageService.getAllMessages(username);

        if(messagesForDatabase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<CreateMessageDTO> messageDTOS = new ArrayList<>();
        for(MessageForDatabase m: messagesForDatabase){
            CreateMessageDTO dto = new CreateMessageDTO(m);
            messageDTOS.add(dto);
        }

        return new ResponseEntity<>(messageDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    @PreAuthorize("hasAuthority('CHANGE_NAME_AND_LAST_NAME')")

    public ResponseEntity<List<CreateMessageDTO>> getAllMessagesForLoggedUser(@RequestHeader(value="Authorization") String authorization){

        List<MessageForDatabase> messagesForDatabase = this.messageService.getAllMessages(UtilityService.getEmailFromToken(authorization));

        if(messagesForDatabase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<CreateMessageDTO> messageDTOS = new ArrayList<>();
        for(MessageForDatabase m: messagesForDatabase){
            CreateMessageDTO dto = new CreateMessageDTO(m.getSubject(), m.getContent(), m.getDateOfSending().toString(),
                    m.getAgent().getEmail(), m.getUser().getEmail());
            messageDTOS.add(dto);
        }

        return new ResponseEntity<>(messageDTOS,HttpStatus.OK);
    }

}
