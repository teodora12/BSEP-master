package com.microservice.usermanagement.service;

import com.microservice.usermanagement.model.Agent;
import com.microservice.usermanagement.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentRepository repository;
    @Override
    public Agent findOne(Long id) {
        for (Agent u : repository.findAll()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Agent> findAll() {
        return repository.findAll();
    }

    @Override
    public Agent save(Agent Agent) {
        return repository.save(Agent);
    }

    @Override
    public void delete(Agent Agent) {
        repository.delete(Agent);
    }

    @Override
    public Agent findByEmail(String email) {
        for (Agent u : repository.findAll()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Agent> acceptedAgents(){
        List<Agent> accepted= new ArrayList<>();
        for(Agent a: repository.findAll()){
            if(a.isAccepted()==true){
                accepted.add(a);
            }
        }
        return accepted;
    }
}
