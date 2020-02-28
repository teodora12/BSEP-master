package com.ftn.agent.restService;

import com.ftn.agent.model.Agent;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import org.springframework.stereotype.Service;

@Service
public interface AgentService {
    AgentForDatabase findAgentByUsername(String username);
    AgentForDatabase getAgentSOAP(String username);
}
