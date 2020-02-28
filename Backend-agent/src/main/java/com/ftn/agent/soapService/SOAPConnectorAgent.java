package com.ftn.agent.soapService;

import com.ftn.agent.model.GetAgentRequest;
import com.ftn.agent.model.GetAgentResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnectorAgent extends WebServiceGatewaySupport {


    public GetAgentResponse getAgentResponse(String username) {

        GetAgentRequest request = new GetAgentRequest();
        request.setUsername(username);

        GetAgentResponse response = (GetAgentResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}
