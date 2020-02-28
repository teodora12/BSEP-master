package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import com.ftn.bsep.repository.AccommodationTypeRepository;
import com.ftn.bsep.service.AccommodationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationTypeServiceImpl implements AccommodationTypeService {


    @Autowired
    AccommodationTypeRepository repository;


    @Override
    public TAccommodationType findOne(Long id) {
        for (TAccommodationType a : repository.findAll()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    @Override
    public TAccommodationType findByTypeName(String name) {
        for (TAccommodationType type : findAll()) {
            if (type.getName().toLowerCase().equals(name.toLowerCase())) {
                return type;
            }
        }
        return null;
    }
    @Override
    public List<TAccommodationType> findAll() {
        return repository.findAll();
    }

    @Override
    public TAccommodationType save(TAccommodationType type) {
        return repository.save(type);
    }

    @Override
    public void delete(TAccommodationType type) {
        repository.delete(type);
    }



}
