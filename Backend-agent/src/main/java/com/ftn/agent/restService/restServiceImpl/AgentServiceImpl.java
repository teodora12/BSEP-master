package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.Address;
import com.ftn.agent.model.Agent;
import com.ftn.agent.model.GetAgentResponse;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import com.ftn.agent.model.forDatabase.Role;
import com.ftn.agent.repository.AgentRepository;
import com.ftn.agent.repository.RoleRepository;
import com.ftn.agent.restService.AddressService;
import com.ftn.agent.restService.AgentService;

import com.ftn.agent.soapService.SOAPConnectorAgent;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private SOAPConnectorAgent soapConnectorAgent;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AgentForDatabase findAgentByUsername(String username) {
        return this.agentRepository.findAgentForDatabaseByEmail(username);
    }

    @Override
    public AgentForDatabase getAgentSOAP(String username) {


        GetAgentResponse response = this.soapConnectorAgent.getAgentResponse(username);
        if(response == null)
        {
            return null;
        }
        Agent agent = response.getAgent();

        if(agent != null && agent.isIsAccepted() == true) {



            AgentForDatabase agentInDatabase = this.agentRepository.findAgentForDatabaseByEmail(username);


            if (agentInDatabase == null) {
                AgentForDatabase newAgent = new AgentForDatabase(agent);
                Address newAddress = new Address(agent.getAddress());
                this.addressService.save(newAddress);
                newAgent.setAddress(newAddress);
                Role role = this.roleRepository.findRoleByName("ROLE_AGENT");
                List<Role> authorities = new ArrayList<>();
                authorities.add(role);
                newAgent.setRoles(authorities);
         //       newAgent.setLastPasswordResetDate(new Timestamp(DateTime.now().getMillis()));
                this.agentRepository.save(newAgent);
                return newAgent;
            }
            else{
                return agentInDatabase;
            }


        }
        return null;
    }
}
