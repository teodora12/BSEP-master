package com.ftn.bsep.service;


import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationCategoryService {

    TAccommodationCategory findOne(Long id);
    List<TAccommodationCategory> findAll();
    TAccommodationCategory save(TAccommodationCategory category);
    void delete(TAccommodationCategory category);
    TAccommodationCategory findByName(String name);

}
