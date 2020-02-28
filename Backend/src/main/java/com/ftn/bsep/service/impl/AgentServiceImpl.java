package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.Agent;
import com.ftn.bsep.repository.AgentRepository;
import com.ftn.bsep.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl  implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent findAgentByUsername(String username) {
        return this.agentRepository.findAgentByUsername(username);
    }

    @Override
    public Agent save(Agent agent) {
        return this.agentRepository.save(agent);
    }
}
