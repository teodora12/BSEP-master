package com.ftn.agent.restService.restServiceImpl;


import com.ftn.agent.model.TAccommodationCategory;
import com.ftn.agent.repository.AccommodationCategoryRepository;
import com.ftn.agent.restService.AccommodationCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationCategoryServiceImpl implements AccommodationCategoryService {

    @Autowired
    AccommodationCategoryRepository repository;

    @Override
    public TAccommodationCategory findOne(Long id) {
        for (TAccommodationCategory category : repository.findAll()) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }


    @Override
    public TAccommodationCategory findByName(String name) {
        for (TAccommodationCategory category : findAll()) {
            if (category.getName().toLowerCase().equals(name.toLowerCase())) {
                return category;
            }
        }
        return null;
    }

    @Override
    public TAccommodationCategory save(TAccommodationCategory category) {
        return this.repository.save(category);
    }

    @Override
    public List<TAccommodationCategory> findAll() {
        return repository.findAll();
    }




}
