package com.microservice.reservation;

import com.microservice.reservation.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TRoomRepository tRoomRepository;

    @Override
    public CreatedReservationDto makeReservation(StartReservationDto startReservationDto, String email) {

        RegularExpressions regularExpressions = new RegularExpressions();

        boolean isIdValid = regularExpressions.isLongValid(startReservationDto.getAccommodationId());
        boolean isAllRoomsIdValid = true;

        List<Boolean> roomIdsValid = new ArrayList<>();
        for (Long roomId: startReservationDto.getRoomIds()){
            boolean isLongValid = regularExpressions.isLongValid(roomId);
            roomIdsValid.add(isLongValid);
        }
        for(Boolean b: roomIdsValid){
            if (b == false){
                isAllRoomsIdValid = false;
                break;
            }
        }
        boolean isNumberOfPeopleValid = regularExpressions.isNumberValid(startReservationDto.getNumberOfPeople());
        boolean isEmailValid = regularExpressions.isEmailValid(email);


        if(!(isIdValid || isAllRoomsIdValid || isNumberOfPeopleValid || isEmailValid))
        {
            return null;
        }


        Reservation reservation = new Reservation();
        reservation.setRoom(new ArrayList<>());
        // ZBOG CENA TREBA ACCOMMODATION
        Accommodation accommodation = this.accommodationRepository.findAccommodationById(startReservationDto.getAccommodationId());

        List<TRoom> rooms = this.tRoomRepository.findAllById(startReservationDto.getRoomIds());
        reservation.setRoom(rooms);

        double price = 0;
        for (TRoom room : rooms) {
            Calendar start = Calendar.getInstance();
            start.setTime(startReservationDto.getArrivalDate());
            Calendar end = Calendar.getInstance();
            end.setTime(startReservationDto.getDepartureDate());
            end.add(Calendar.DATE, 1);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                for (Item item : accommodation.getPricelist().getItem()) {
                    if (date.after(item.getStartDatePeriod()) && date.before(item.getEndDatePeriod()) &&
                            room.getCapacity() == item.getCapacity()) {
                        price += item.getPrice();                      // price for each day
                    }
                }
            }

//            Date loop = startReservationDto.getArrivalDate();
//            while (loop.before(startReservationDto.getDepartureDate())) {
//                for (Item item : accommodation.getPricelist().getItem()) {
//                    if (loop.after(item.getStartDatePeriod()) && loop.before(item.getEndDatePeriod()) &&
//                            room.getCapacity() == item.getCapacity()) {
//                        price += item.getPrice();                      // price for each day
//                    }
//                }
//                loop.plusDay = loop + 1;
//            }
        }
        List<TAdditionalService> additionalServices = new ArrayList<>();
        if (startReservationDto.getAdditionalServicesWithPrices() != null) {
            for (TAdditionalServicesWithPrices additionalServicesWithPrice : startReservationDto.getAdditionalServicesWithPrices()) {
                price += additionalServicesWithPrice.getPrice();
                additionalServices.add(additionalServicesWithPrice.getAdditionalService());
            }
        }
//        int temp = toIntExact();
        reservation.setStatus("created");
        reservation.setAccommodationId(accommodation.getId());
        reservation.setPaidAdditionalServices(additionalServices);
        reservation.setNumberOfDaysForCancellation(new Long(accommodation.getCancellation().getDays()));
        reservation.setPrice(new BigDecimal(price));
        reservation.setArrivalDate(startReservationDto.getArrivalDate());
        reservation.setDepartureDate(startReservationDto.getDepartureDate());
        reservation.setUser(this.userRepository.findUserByEmail(email));
        Reservation reservationFinal = this.reservationRepository.save(reservation);
        return new CreatedReservationDto(reservationFinal.getId(), reservationFinal.getPrice(), reservationFinal.getArrivalDate(),
                reservationFinal.getDepartureDate(), reservationFinal.getRoom(), reservationFinal.getUser().getEmail(),
                reservation.getPaidAdditionalServices(), reservation.getNumberOfDaysForCancellation(), reservation.getAccommodationId());
    }

    @Override
    public List<CreatedReservationDto> getAllUserReservations(String email) {

        List<Reservation> reservations = this.reservationRepository.findAllByUser_EmailEquals(email);
        List<CreatedReservationDto> reservationFinalList= new ArrayList<>();

        for (Reservation reservationFinal : reservations) {
            reservationFinalList.add(new CreatedReservationDto(reservationFinal.getId(), reservationFinal.getPrice(), reservationFinal.getArrivalDate(),
                    reservationFinal.getDepartureDate(), reservationFinal.getRoom(), reservationFinal.getUser().getEmail(), reservationFinal.getPaidAdditionalServices(),
                    reservationFinal.getNumberOfDaysForCancellation(), reservationFinal.getAccommodationId()));
        }
        return reservationFinalList;
    }

    @Override
    public void cancellReservation(Long id) {
        Reservation reservation = this.reservationRepository.findReservationById(id);

        if (reservation != null) {
            this.reservationRepository.deleteById(id);
        }
    }


}
