package com.ftn.agent.soapService;

import com.ftn.agent.model.RegisterAgentRequest;
import com.ftn.agent.model.RegisterAgentResponse;
import com.ftn.agent.model.User;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnectorUser extends WebServiceGatewaySupport {


    public RegisterAgentResponse registerAgentRequest(User user) {

        RegisterAgentRequest request = new RegisterAgentRequest();
        request.setUser(user);

        RegisterAgentResponse response = (RegisterAgentResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
