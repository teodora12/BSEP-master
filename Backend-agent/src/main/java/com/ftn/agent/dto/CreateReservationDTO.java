package com.ftn.agent.dto;

import com.ftn.agent.model.Reservation;
import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateReservationDTO {

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
      String agentUsername;

    @NotNull
 //   @SafeHtml
    private  Date startDate;

    @NotNull
//    @SafeHtml
//    @NotBlank
    private  Date endDate;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String accommodationName;

    @NotNull
//    @SafeHtml
  //  @NotBlank
    private  Long roomId;

    public CreateReservationDTO () {

    }

    public CreateReservationDTO (Reservation reservation){

    }

    public String getAgentUsername() {
        return agentUsername;
    }

    public void setAgentUsername(String agentUsername) {
        this.agentUsername = agentUsername;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
