package com.ftn.agent.soapService;

import com.ftn.agent.model.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnectorMessage extends WebServiceGatewaySupport {

    public GetMessagesResponse getMessageResponse(String username) {

        GetMessagesRequest request = new GetMessagesRequest();
        request.setUsername(username);

        GetMessagesResponse response = (GetMessagesResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public SendMessageResponse sendMessageResponse(Message message){
        SendMessageRequest request = new SendMessageRequest();

        request.setMessage(message);

        SendMessageResponse response = (SendMessageResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
