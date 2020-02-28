package com.ftn.agent.restService;

import com.ftn.agent.model.TAccommodationCategory;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;

@Service
public interface AccommodationCategoryService {

    TAccommodationCategory findOne(Long id);
    List<TAccommodationCategory> findAll();
    TAccommodationCategory findByName(String name);
    TAccommodationCategory save(TAccommodationCategory category);

}
