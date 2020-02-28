package com.ftn.bsep.dto.accommodation;

import lombok.Data;

import java.util.List;

@Data
public class AccommodationIdPictureBytesDto {

    private Long id;
    private List<byte[]> picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<byte[]> getPicture() {
        return picture;
    }

    public void setPicture(List<byte[]> picture) {
        this.picture = picture;
    }
}
