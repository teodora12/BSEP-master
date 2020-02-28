package com.ftn.agent.dto;

import com.ftn.agent.model.TRoom;
import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

public class CreateAndUpdateRoomDTO {

    @NotNull
    private BigInteger roomNumber;

    private  BigInteger newRoomNumber;

    @SafeHtml
    private @SQLInjectionSafe String accommodationName;

    @NotNull
    private  BigInteger floor;

    @NotNull
    private  BigInteger capacity;

  //  @NotNull
    //@SafeHtml
  //  @NotBlank
    private  Long roomId;

    public CreateAndUpdateRoomDTO(){

    }

    public CreateAndUpdateRoomDTO(TRoom room){
        this.roomNumber = room.getRoomNumber();
        this.floor = room.getFloor();
        this.capacity = room.getCapacity();
        this.roomId =room.getId();
    }

    public BigInteger getNewRoomNumber() {
        return newRoomNumber;
    }

    public void setNewRoomNumber(BigInteger newRoomNumber) {
        this.newRoomNumber = newRoomNumber;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public BigInteger getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(BigInteger roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigInteger getFloor() {
        return floor;
    }

    public void setFloor(BigInteger floor) {
        this.floor = floor;
    }

    public void setCapacity(BigInteger capacity) {
        this.capacity = capacity;
    }


    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }
}
