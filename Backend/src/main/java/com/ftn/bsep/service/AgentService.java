package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.Agent;
import org.springframework.stereotype.Service;

@Service
public interface AgentService {

    Agent findAgentByUsername(String username);
    Agent save (Agent agent);
}
