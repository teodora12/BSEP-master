package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AccommodationForDatabase;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import com.ftn.agent.repository.AccommodationRepository;
import com.ftn.agent.restService.*;
import com.ftn.agent.soapService.SOAPConnectorAccommodation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private SOAPConnectorAccommodation soapConnectorAccommodation;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private CancellationService cancellationService;

    @Autowired
    private AccommodationTypeService accommodationTypeService;

    @Autowired
    private AccommodationCategoryService accommodationCategoryService;

    @Autowired
    private AdditionalServiceService additionalServiceService;

    @Autowired
    private AdditionalServicePriceService additionalServicePriceService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private RoomService roomService;

    @Override
    public List<AccommodationForDatabase> findAccommodations() {
        List<AccommodationForDatabase> accommodations = this.accommodationRepository.findAll();

        return accommodations;
    }

    @Override
    public AccommodationForDatabase findAccommodationById(Long id) {
        return this.accommodationRepository.findAccommodationForDatabaseById(id);
    }

    @Override
    public List<AccommodationForDatabase> getAccommodationByAgentUsername(String username) {


        GetAgentAccommodationsResponse response = this.soapConnectorAccommodation.getAgentAccommodationsResponse(username);

       // Agent agent = this.agentService.findAgentByUsername(username);
        AgentForDatabase agentForDatabase = this.agentService.findAgentByUsername(username);

        List<AccommodationForDatabase> newAccommodationsForDatabases = new ArrayList<>();
        for(Accommodation accommodation: response.getAccommodation()){
            AccommodationForDatabase accommodationForDatabase = this.accommodationRepository.findAccommodationForDatabaseByName(accommodation.getName());

               if(accommodationForDatabase!= null){

               accommodationForDatabase.getRoom().removeAll(accommodationForDatabase.getRoom());
               accommodationForDatabase.getPicture().removeAll(accommodationForDatabase.getPicture());
               accommodationForDatabase.getAdditionalServiceWithPrices().removeAll(accommodationForDatabase.getAdditionalServiceWithPrices());
//                for(TAdditionalServicesWithPrices wp: ac.getAdditionalServiceWithPrices()){
//                    this.additionalServicePriceService.remove(wp);
//                }


          //      ac.setPricelist(null);
               accommodationForDatabase.getComments().removeAll(accommodationForDatabase.getComments());
         //       ac.setCancellation(null);
        //        ac.setAccommodationCategory(null);
        //        ac.setAccommodationType(null);
        //        ac.setAddress(null);
               accommodationForDatabase.getAgent().removeAll(accommodationForDatabase.getAgent());

                this.accommodationRepository.delete(accommodationForDatabase);

            }
                AccommodationForDatabase newAccomodaAccommodationForDatabase= new AccommodationForDatabase();
            newAccomodaAccommodationForDatabase.setName(accommodation.getName());
            newAccomodaAccommodationForDatabase.setDescription(accommodation.getDescription());
            newAccomodaAccommodationForDatabase.setCapacity(accommodation.getCapacity());
            newAccomodaAccommodationForDatabase.setRate(accommodation.getRate());
                newAccomodaAccommodationForDatabase.getAgent().add(agentForDatabase);


                Address address = accommodation.getAddress();
                Address newAddress = new Address(address);
                this.addressService.save(newAddress);
            newAccomodaAccommodationForDatabase.setAddress(newAddress);

                TCancellation cancellation = accommodation.getCancellation();
                TCancellation newCancellation = new TCancellation(cancellation);
                this.cancellationService.save(newCancellation);
            newAccomodaAccommodationForDatabase.setCancellation(newCancellation);

                TAccommodationType accommodationType = accommodation.getAccommodationType();
                TAccommodationType typeDatabase = this.accommodationTypeService.findByTypeName(accommodationType.getName());
                if(typeDatabase == null) {
                    TAccommodationType newAccType = new TAccommodationType(accommodationType);
                    this.accommodationTypeService.save(newAccType);
                    newAccomodaAccommodationForDatabase.setAccommodationType(newAccType);
                }else {
                    newAccomodaAccommodationForDatabase.setAccommodationType(typeDatabase);
                }

                TAccommodationCategory category = accommodation.getAccommodationCategory();
                TAccommodationCategory categoryDatabase = this.accommodationCategoryService.findByName(category.getName());

                if(categoryDatabase == null){
                    TAccommodationCategory newAccCategory = new TAccommodationCategory(category);
                    this.accommodationCategoryService.save(newAccCategory);
                    newAccomodaAccommodationForDatabase.setAccommodationCategory(newAccCategory);
                }else {
                    newAccomodaAccommodationForDatabase.setAccommodationCategory(categoryDatabase);
                }

//                List<TComment> comments = accommodation.getComments();
//                List<TComment> newComments = new ArrayList<>();
//
//                if(comments.size() != 0){
//                    for(TComment c: comments){
//                        User user = this.userService.findUserByEmail(c.getUser().getUsername());
//                        TComment comment = new TComment(c);
//                        comment.setUser(user);
//                        comment.setContent(c.getContent());
//                        newComments.add(comment);
//                    }
//                    this.commentService.saveAll(newComments);
//                    newAccomodaAccommodationForDatabase.getComments().addAll(newComments);
//
//                } else {
//                    newAccomodaAccommodationForDatabase.getComments().addAll(newComments);
//                }

                List<TRoom> rooms = accommodation.getRoom();
                List<TRoom> newRooms = new ArrayList<>();

                if(rooms.size() != 0) {
                    for (TRoom r : rooms) {
                        TRoom room = this.roomService.findRoomByAccNameAndRoomNumber(r.getAccommodationName(), r.getRoomNumber());
                        if(room != null) {
                            newRooms.add(room);
                        } else {
                            TRoom room1 = new TRoom(r);
                            newRooms.add(room1);
                        }

                    }
                    this.roomService.saveAll(newRooms);
                    newAccomodaAccommodationForDatabase.getRoom().addAll(newRooms);
                }else{
                    newAccomodaAccommodationForDatabase.getRoom().addAll(newRooms);
                }


                Pricelist pricelist = accommodation.getPricelist();
                List<Item> newItems = new ArrayList<>();
                Pricelist newPricelist = new Pricelist();
                if(pricelist != null && !(pricelist.getItem().isEmpty())) {

                        for (Item i : pricelist.getItem()) {
                            Item item = new Item(i);
                            newItems.add(item);
                        }
                        this.itemService.saveAll(newItems);
                        newPricelist.getItem().addAll(newItems);
                        this.pricelistService.save(newPricelist);
                    newAccomodaAccommodationForDatabase.setPricelist(newPricelist);
                }else{
                    newAccomodaAccommodationForDatabase.setPricelist(newPricelist);
                }



                List<TAdditionalServicesWithPrices> additionalServicesWithPrices = accommodation.getAdditionalServiceWithPrices();
                List<TAdditionalServicesWithPrices> newListWithPrices = new ArrayList<>();

                if(!(additionalServicesWithPrices.isEmpty())) {
                    for (TAdditionalServicesWithPrices withPrices : additionalServicesWithPrices) {

                        TAdditionalServicesWithPrices addWithPrices = new TAdditionalServicesWithPrices();
                        TAdditionalService additionalService = this.additionalServiceService.findByName(withPrices.getAdditionalServices().getName());
                        if(additionalService == null){
                            TAdditionalService as = new TAdditionalService(withPrices.getAdditionalServices());
                            this.additionalServiceService.save(as);
                            addWithPrices.setAdditionalServices(as);
                            addWithPrices.setPrice(withPrices.getPrice());

                        }else {
                            addWithPrices.setAdditionalServices(additionalService);
                            addWithPrices.setPrice(withPrices.getPrice());
                        }
                        this.additionalServicePriceService.save(addWithPrices);

                        newListWithPrices.add(addWithPrices);
                    }


                    newAccomodaAccommodationForDatabase.getAdditionalServiceWithPrices().addAll(newListWithPrices);
                }

         //       newAccommodation.getAdditionalServiceWithPrices().addAll(newListWithPrices);

            newAccommodationsForDatabases.add(newAccomodaAccommodationForDatabase);
                this.accommodationRepository.save(newAccomodaAccommodationForDatabase);

        }


        response.getAccommodation().removeAll(response.getAccommodation());
    //    response.getAccommodation().addAll(newAccommodationsForDatabases);
        return newAccommodationsForDatabases;
    }

    @Override
    public AccommodationForDatabase findAccommodationByName(String name) {
        return this.accommodationRepository.findAccommodationForDatabaseByName(name);
    }

    @Override
    public AccommodationForDatabase save(AccommodationForDatabase accommodation) {
        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public AccommodationForDatabase findAccommodationByRoom(TRoom room) {
        return this.accommodationRepository.findAccommodationForDatabaseByRoom(room);
    }



}
