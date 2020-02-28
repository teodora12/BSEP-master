package com.ftn.agent.controller;

import com.ftn.agent.dto.AgentDTO;
import com.ftn.agent.dto.CreateAndUpdateAccDTO;
import com.ftn.agent.model.Accommodation;
import com.ftn.agent.model.Agent;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import com.ftn.agent.restService.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;


    @GetMapping(value = "/{username}")
    public ResponseEntity<AgentDTO> getAgentByUsername(@PathVariable String username)  {

        AgentForDatabase agent = this.agentService.getAgentSOAP(username);
        if(agent == null){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        AgentDTO dto = new AgentDTO(agent);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
