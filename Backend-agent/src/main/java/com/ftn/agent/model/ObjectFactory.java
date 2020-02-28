
package com.ftn.agent.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftn.agent.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {



    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftn.bsep.model.temp
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Reservation }
     *
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link User }
     *
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Address }
     *
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link TRoom }
     *
     */
    public TRoom createTRoom() {
        return new TRoom();
    }

    /**
     * Create an instance of {@link ReserveRoomResponse }
     *
     */
    public ReserveRoomResponse createReserveRoomResponse() {
        return new ReserveRoomResponse();
    }

    /**
     * Create an instance of {@link GetReservationsRequest }
     *
     */
    public GetReservationsRequest createGetReservationsRequest() {
        return new GetReservationsRequest();
    }

    /**
     * Create an instance of {@link CreateAccommodationRequest }
     *
     */
    public CreateAccommodationRequest createCreateAccommodationRequest() {
        return new CreateAccommodationRequest();
    }

    /**
     * Create an instance of {@link Accommodation }
     *
     */
    public Accommodation createAccommodation() {
        return new Accommodation();
    }

    /**
     * Create an instance of {@link TAccommodationType }
     *
     */
    public TAccommodationType createTAccommodationType() {
        return new TAccommodationType();
    }

    /**
     * Create an instance of {@link TAccommodationCategory }
     *
     */
    public TAccommodationCategory createTAccommodationCategory() {
        return new TAccommodationCategory();
    }

    /**
     * Create an instance of {@link TCancellation }
     *
     */
    public TCancellation createTCancellation() {
        return new TCancellation();
    }

    /**
     * Create an instance of {@link Agent }
     *
     */
    public Agent createAgent() {
        return new Agent();
    }

    /**
     * Create an instance of {@link TAdditionalServicesWithPrices }
     *
     */
    public TAdditionalServicesWithPrices createTAdditionalServicesWithPrices() {
        return new TAdditionalServicesWithPrices();
    }

    /**
     * Create an instance of {@link TComment }
     *
     */
    public TComment createTComment() {
        return new TComment();
    }

    /**
     * Create an instance of {@link ReserveRoomRequest }
     *
     */
    public ReserveRoomRequest createReserveRoomRequest() {
        return new ReserveRoomRequest();
    }

    /**
     * Create an instance of {@link GetReservationsResponse }
     *
     */
    public GetReservationsResponse createGetReservationsResponse() {
        return new GetReservationsResponse();
    }

    /**
     * Create an instance of {@link CreateAccommodationResponse }
     *
     */
    public CreateAccommodationResponse createCreateAccommodationResponse() {
        return new CreateAccommodationResponse();
    }

    /**
     * Create an instance of {@link TAdditionalService }
     *
     */
    public TAdditionalService createTAdditionalService() {
        return new TAdditionalService();
    }

    /**
     * Create an instance of {@link Pricelist }
     *
     */
    public Pricelist createPricelist() {
        return new Pricelist();
    }

}
