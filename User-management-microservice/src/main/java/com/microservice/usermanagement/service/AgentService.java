package com.microservice.usermanagement.service;

import com.microservice.usermanagement.model.Agent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService {

    Agent findOne(Long id);
    List<Agent> findAll();
    List<Agent> acceptedAgents();
    Agent save(Agent user);
    void delete(Agent user);
    Agent findByEmail(String email);

}
