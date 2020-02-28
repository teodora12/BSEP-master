package com.ftn.bsep.dto.accommodation;

import lombok.Data;

import java.util.List;

@Data
public class AccommodationIdPictureDto {
    private Long id;
    private List<String> picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture;
    }
}
