package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class AgentEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agent";

    @Autowired
    private AgentService agentService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAgentRequest")
    @ResponsePayload
    public GetAgentResponse getAccommodationsByAgentUsername(@RequestPayload GetAgentRequest request) {

        GetAgentResponse response = new GetAgentResponse();
        Agent agent = this.agentService.findAgentByUsername(request.getUsername());

        if(agent == null) {
            return null;
        }


        response.setAgent(agent);


        return response;
    }

}
