package com.ftn.agent.soapService;

import com.ftn.agent.model.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigInteger;

public class SOAPConnectorAccommodation extends WebServiceGatewaySupport {

//    public CreateAccommodationResponse createAccommodationResponse(Accommodation accommodation) {
//
//        CreateAccommodationRequest request = new CreateAccommodationRequest();
//
//        request.setAccommodation(accommodation);
//
//        CreateAccommodationResponse response = (CreateAccommodationResponse) getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback("https://localhost/ws/CreateAccomodationRequest"));
//
//        return response;
//    }

    public CreateRoomResponse createRoom(String accName, TRoom room){
        CreateRoomRequest request = new CreateRoomRequest();
        request.setAccommodationName(accName);
        request.setRoom(room);

        CreateRoomResponse response = (CreateRoomResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }


    public UpdateRoomResponse updateRoom(String accName, TRoom room, BigInteger oldRoomNumber)
    {
        UpdateRoomRequest request = new UpdateRoomRequest();
        request.setAccommodationName(accName);
        request.setRoom(room);
        request.setOldRoomNumber(oldRoomNumber);

        UpdateRoomResponse response = (UpdateRoomResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }


    public DeleteRoomResponse deleteRoom(TRoom room,String accName) {

        DeleteRoomRequest request = new DeleteRoomRequest();
        request.setAccommodationName(accName);
        request.setRoom(room);

        DeleteRoomResponse response = (DeleteRoomResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

    public GetAgentAccommodationsResponse getAgentAccommodationsResponse(String username)
    {
        GetAgentAccommodationsRequest request = new GetAgentAccommodationsRequest();
        request.setUsername(username);

        GetAgentAccommodationsResponse response = (GetAgentAccommodationsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }
}
