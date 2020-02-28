package com.ftn.agent.restService;

import com.ftn.agent.model.TAccommodationType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationTypeService {

    TAccommodationType findOne(Long id);
    List<TAccommodationType> findAll();
    TAccommodationType findByTypeName(String name);
    TAccommodationType save(TAccommodationType type);

}
