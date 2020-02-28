package com.ftn.agent.soapService;

import com.ftn.agent.model.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SOAPConnectorReservation extends WebServiceGatewaySupport {

    public ReserveRoomResponse reserveRoomResponse(Reservation reserv, String accommodationName) {

        ReserveRoomRequest request = new ReserveRoomRequest();
        request.setReservation(reserv);
        request.setAccommodationName(accommodationName);

        ReserveRoomResponse response = (ReserveRoomResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }


    public GetReservationsResponse getReservationsResponse(String  username) {


        GetReservationsRequest request = new GetReservationsRequest();
        request.setUsername(username);

        GetReservationsResponse response = (GetReservationsResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }


    public ChangeReservationStatusResponse changeReservationStatus(Reservation  reservation) {


        ChangeReservationStatusRequest request = new ChangeReservationStatusRequest();
        request.setReservation(reservation);

        ChangeReservationStatusResponse response = (ChangeReservationStatusResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}
