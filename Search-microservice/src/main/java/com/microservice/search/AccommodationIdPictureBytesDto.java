package com.microservice.search;

import lombok.Data;

import java.util.List;

@Data
public class AccommodationIdPictureBytesDto {

    private Long id;
    private List<byte[]> picture;
}
