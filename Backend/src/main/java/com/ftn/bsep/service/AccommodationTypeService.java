package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationTypeService {

    TAccommodationType findOne(Long id);
    List<TAccommodationType> findAll();
    TAccommodationType save(TAccommodationType type);
    void delete(TAccommodationType type);
    TAccommodationType findByTypeName(String name);


}
