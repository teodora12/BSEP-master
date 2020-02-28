package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import com.ftn.bsep.repository.AdditionalServiceRepository;
import com.ftn.bsep.service.AdditionalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

    @Autowired
    AdditionalServiceRepository repository;

    @Override
    public List<TAdditionalService> findAll() {
        return repository.findAll();
    }

    @Override
    public TAdditionalService findOne(Long id) {
        for (TAdditionalService additionalService : findAll()) {
            if (additionalService.getId() == id) {
                return additionalService;
            }
        }
        return null;
    }

    @Override
    public TAdditionalService save(TAdditionalService additionalService) {
        return repository.save(additionalService);
    }

    @Override
    public void delete(TAdditionalService additionalService) {
        repository.delete(additionalService);
    }

    @Override
    public TAdditionalService findByName(String name) {
        for (TAdditionalService additionalService : findAll()) {
            if (additionalService.getName().toLowerCase().equals(name.toLowerCase())) {
                return additionalService;
            }
        }
        return null;
    }
}
