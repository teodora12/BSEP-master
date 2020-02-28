package com.ftn.bsep.service.impl;


import com.ftn.bsep.dto.accommodation.AdditionalWithPricesDTO;
import com.ftn.bsep.dto.accommodation.CreateAndUpdateAccDTO;
import com.ftn.bsep.dto.accommodation.ItemDTO;
import com.ftn.bsep.model.AccommodationForDatabase;
import com.ftn.bsep.model.CommentForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.repository.AccommodationRepository;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;


    @Autowired
    private AccommodationCategoryService accommodationCategoryService;

    @Autowired
    private AccommodationTypeService accommodationTypeService;

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private CancellationService cancellationService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AdditionalServicePriceService additionalServicePriceService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private AdditionalServiceService additionalServiceService;



    @Override
    public AccommodationForDatabase newAccommodation(CreateAndUpdateAccDTO newAccommodationDTO) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isAccDescriptionValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());

//       boolean isAddressStreetValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getStreet());
//        boolean isAddressCountryValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getCountry());
//        boolean isAddressCityValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getCity());
//        boolean isAddrresStreetNumValid = regularExpressions.isStreetNumberValid(newAccommodationDTO.getAddress().getStreetNumber().toString());
        boolean isAddressLongitudeValid = regularExpressions.isLongitudeAndLatitudeValid(newAccommodationDTO.getAddress().getLongitude());
        boolean isAddressLatitudeValid = regularExpressions.isLongitudeAndLatitudeValid(newAccommodationDTO.getAddress().getLatitude());

        if(!(isAccDescriptionValid  && isAddressLatitudeValid &&
        isAddressLatitudeValid && isAddressLongitudeValid)){
            return null;
        }


        Accommodation accommodation = new Accommodation(newAccommodationDTO);


            TAccommodationCategory category = this.accommodationCategoryService.findOne(newAccommodationDTO.getCategory().getId());
            TAccommodationType type = this.accommodationTypeService.findOne(newAccommodationDTO.getType().getId());

            accommodation.setAddress(newAccommodationDTO.getAddress());
            Address address = addressService.findAddressById(newAccommodationDTO.getAddress().getId());
            if(address == null) {
                this.addressService.save(newAccommodationDTO.getAddress());
            }



            this.itemService.saveAll(accommodation.getPricelist().getItem());

            accommodation.setAccommodationCategory(category);
            accommodation.setAccommodationType(type);
            this.cancellationService.save(accommodation.getCancellation());
            this.pricelistService.save(accommodation.getPricelist());

        List<AdditionalWithPricesDTO> additionalServicesDTO = newAccommodationDTO.getAdditionalServicesWithPrices();

        List<TAdditionalServicesWithPrices> additionalServicesWithPrices = new ArrayList<>();
        for(AdditionalWithPricesDTO dto : additionalServicesDTO) {
            TAdditionalServicesWithPrices additional = new TAdditionalServicesWithPrices();
            additional.setPrice(dto.getPrice());
            TAdditionalService service = this.additionalServiceService.findOne(dto.getId());
            additional.setAdditionalServices(service);
            additionalServicesWithPrices.add(additional);
        }


          additionalServicePriceService.saveAll(additionalServicesWithPrices);

          accommodation.getAdditionalServiceWithPrices().addAll(additionalServicesWithPrices);
          this.additionalServicePriceService.saveAll(accommodation.getAdditionalServiceWithPrices());

        AccommodationForDatabase accommodationForDatabase = new AccommodationForDatabase(accommodation);
            this.accommodationRepository.save(accommodationForDatabase);
            return accommodationForDatabase;


    }

    @Override
    public AccommodationForDatabase updateAccommodation(CreateAndUpdateAccDTO newAccommodationDTO) {


        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isAccDescriptionValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());
        //     boolean isAccNameValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());
        //     boolean isAccAdditionalServicePriceValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());
        //     boolean isAccPricelistItemPriceValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());
        //     boolean isAccPricelistItemRoomCapacityValid = regularExpressions.isAccDescriptionValid(newAccommodationDTO.getDescription());
//        boolean isAddressStreetValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getStreet());
//        boolean isAddressCountryValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getCountry());
//        boolean isAddressCityValid = regularExpressions.isAddressValid(newAccommodationDTO.getAddress().getCity());
//        boolean isAddrresStreetNumValid = regularExpressions.isStreetNumberValid(newAccommodationDTO.getAddress().getStreetNumber().toString());
        boolean isAddressLongitudeValid = regularExpressions.isLongitudeAndLatitudeValid(newAccommodationDTO.getAddress().getLongitude());
        boolean isAddressLatitudeValid = regularExpressions.isLongitudeAndLatitudeValid(newAccommodationDTO.getAddress().getLatitude());

        if(!(isAccDescriptionValid &&  isAddressLatitudeValid &&
               isAddressLatitudeValid && isAddressLongitudeValid )){
            return null;
        }

        System.out.println("LALALALA" + newAccommodationDTO.getId());
        AccommodationForDatabase accommodation = this.accommodationRepository.findAccommodationForDatabaseById(newAccommodationDTO.getId());



       TAccommodationCategory category = this.accommodationCategoryService.findOne(newAccommodationDTO.getCategory().getId());
    TAccommodationType type = this.accommodationTypeService.findOne(newAccommodationDTO.getType().getId());
      TCancellation cancellation = this.cancellationService.findCancellationById(newAccommodationDTO.getCancellation().getId());
       cancellation.setDays(newAccommodationDTO.getCancellation().getDays());
     cancellation.setIsEnabled(newAccommodationDTO.getCancellation().isIsEnabled());
        this.cancellationService.save(cancellation);
       this.accommodationCategoryService.save(category);


        System.out.println(newAccommodationDTO.getCategory().getId()+ "lalalala");



        System.out.println(newAccommodationDTO.getAddress().getCountry() + "adresa");
        Address address = addressService.findAddressById(newAccommodationDTO.getAddress().getId());
        address.setCity(newAccommodationDTO.getAddress().getCity());
        address.setCountry(newAccommodationDTO.getAddress().getCountry());
        address.setStreet(newAccommodationDTO.getAddress().getStreet());
        address.setStreetNumber(newAccommodationDTO.getAddress().getStreetNumber());
        address.setLatitude(newAccommodationDTO.getAddress().getLatitude());
        address.setLongitude(newAccommodationDTO.getAddress().getLongitude());

        if(address == null) {
            this.addressService.save(address);
        }

        accommodation.setAccommodationCategory(category);
       accommodation.setAccommodationType(type);
       accommodation.setCancellation(cancellation);
        accommodation.setDescription(newAccommodationDTO.getDescription());
        accommodation.setName(newAccommodationDTO.getName());
        accommodation.setAddress(newAccommodationDTO.getAddress());
        accommodation.setCapacity(newAccommodationDTO.getCapacity());
        accommodation.setAgent(newAccommodationDTO.getAgents());



        //TODO trebalo bi da se izbrisu iz tabele item, ali je exc, isto i za addService

          List<Item> items = accommodation.getPricelist().getItem();
         // items.removeAll(items);
//        itemService.saveAll(items);

        Pricelist pricelist = this.pricelistService.findPricelistById(accommodation.getPricelist().getId());


        for(ItemDTO dto : newAccommodationDTO.getPricelist().getItemDTOS()){
            Item item = new Item(dto);
            pricelist.getItem().add(item);
        }

        accommodation.setPricelist(pricelist);
        this.itemService.saveAll(pricelist.getItem());
        this.pricelistService.save(pricelist);

        List<TAdditionalServicesWithPrices> additionalServices =  accommodation.getAdditionalServicesWithPrices();
        additionalServices.removeAll(additionalServices);

        List<AdditionalWithPricesDTO> dtos = newAccommodationDTO.getAdditionalServicesWithPrices();
        List<TAdditionalServicesWithPrices> additionalServicesWithPrices = new ArrayList<>();
        for(AdditionalWithPricesDTO dto : dtos) {


            TAdditionalServicesWithPrices withPrices = new TAdditionalServicesWithPrices();
            withPrices.setPrice(dto.getPrice());
            TAdditionalService service = this.additionalServiceService.findOne(dto.getId());
            withPrices.setAdditionalServices(service);
            additionalServicesWithPrices.add(withPrices);
        }


              additionalServicePriceService.saveAll(additionalServicesWithPrices);


        accommodation.getAdditionalServicesWithPrices().addAll(additionalServicesWithPrices);
        this.additionalServicePriceService.saveAll(accommodation.getAdditionalServicesWithPrices());



        this.accommodationRepository.save(accommodation);

        return accommodation;
    }

    @Override
    public AccommodationForDatabase save(AccommodationForDatabase accommodationForDatabase) {
        return this.accommodationRepository.save(accommodationForDatabase);
    }

    @Override
    public AccommodationForDatabase findAccommodationForDatabaseByName(String name) {
        return this.accommodationRepository.findAccommodationForDatabaseByName(name);
    }

    @Override
    public List<AccommodationForDatabase> getAll() {
        return this.accommodationRepository.findAll();
    }

//    @Override
//    public List<Accommodation> findAccommodations() {
//        List<Accommodation> accommodations = this.accommodationRepository.findAll();
//
//        return accommodations;
//    }
//
    @Override
    public AccommodationForDatabase findAccommodationById(Long id) {
        return this.accommodationRepository.findAccommodationForDatabaseById(id);
    }

    @Override
    public void delete(AccommodationForDatabase category) {
        accommodationRepository.delete(category);
    }




}
