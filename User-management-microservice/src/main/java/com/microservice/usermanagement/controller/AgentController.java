package com.microservice.usermanagement.controller;


import com.microservice.usermanagement.model.Address;
import com.microservice.usermanagement.model.Agent;
import com.microservice.usermanagement.model.AgentDTO;
import com.microservice.usermanagement.service.AgentService;
import com.microservice.usermanagement.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;


    @RequestMapping(value="/accepted", method= RequestMethod.GET)
    public ResponseEntity<List<Agent>> getAcceptedAgents() {
        return new ResponseEntity<>(agentService.acceptedAgents(),HttpStatus.OK);
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<List<Agent>> getAgents() {
        return new ResponseEntity<>(agentService.findAll(), HttpStatus.OK);
    }

   /* @RequestMapping(value = "/addAgent", method = RequestMethod.POST)
    public ResponseEntity<Object> addAgents(@RequestBody AgentDTO agent) {

        String name = agent.getName();
        String surname = agent.getSurname();
        String email = agent.getEmail();
        String password = agent.getPassword();
        String username= agent.getUsername();
        int company=agent.getCompanyNumber();
        Address address= agent.getAddress();

        Agent a= new Agent(name,surname,address,company,username,email,password);
        agentService.save(a);
        return new ResponseEntity<>(this.agentService.findByEmail(agent.getEmail()),HttpStatus.CREATED);
    }*/

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> getagent(@PathVariable Long id) {
        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isNumberValid(id);
        if(isIdValid == false){
            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
        }
        Agent agent = agentService.findOne(id);
        if (agent == null) {
            return new ResponseEntity<>("agent not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @RequestMapping(value="/email/{email}", method=RequestMethod.GET)
    public ResponseEntity<Object> getagentByEmail(@PathVariable String email) {
        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(email);
        if(isEmailValid == false){
            return new ResponseEntity<>("Email is not valid", HttpStatus.FORBIDDEN);

        }
        Agent agent = agentService.findByEmail(email);
        if (agent == null) {
            return new ResponseEntity<>("agent not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{email}", method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteagent(@PathVariable String email) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(email);
        if(isEmailValid == false){
            return new ResponseEntity<>("Email is not valid", HttpStatus.FORBIDDEN);

        }
        Agent agent = agentService.findByEmail(email);
        if (agent == null) {
            return new ResponseEntity<>("agent not found.", HttpStatus.NOT_FOUND);
        }
        agentService.delete(agent);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value="/activate-agent/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> activateAgent(@PathVariable Long id) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isNumberValid(id);
        if(isIdValid == false){
            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
        }
        Agent agent = agentService.findOne(id);
        if (agent == null) {
            return new ResponseEntity<>("agent not found.", HttpStatus.NOT_FOUND);
        }
        agent.setAccepted(true);
        agentService.save(agent);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

    @RequestMapping(value="/block-agent/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> blockagent(@PathVariable Long id) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isIdValid = regularExpressions.isNumberValid(id);
        if(isIdValid == false){
            return new ResponseEntity<>("Id is not valid", HttpStatus.FORBIDDEN);
        }

        Agent agent = agentService.findOne(id);
        if (agent == null) {
            return new ResponseEntity<>("agent not found.", HttpStatus.NOT_FOUND);
        }
        agent.setAccepted(false);
        agentService.save(agent);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
    
}
