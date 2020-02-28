package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import com.ftn.bsep.repository.AccommodationCategoryRepository;
import com.ftn.bsep.service.AccommodationCategoryService;
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
    public List<TAccommodationCategory> findAll() {
        return repository.findAll();
    }


    @Override
    public TAccommodationCategory save(TAccommodationCategory category) {
        return repository.save(category);
    }

    @Override
    public void delete(TAccommodationCategory category) {
        repository.delete(category);
    }


}
