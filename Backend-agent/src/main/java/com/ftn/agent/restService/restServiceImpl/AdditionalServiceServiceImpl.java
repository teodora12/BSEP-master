package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.TAdditionalService;
import com.ftn.agent.repository.AdditionalServiceRepository;
import com.ftn.agent.restService.AdditionalServiceService;
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
    public TAdditionalService findByName(String name) {
        for (TAdditionalService additionalService : findAll()) {
            if (additionalService.getName().toLowerCase().equals(name.toLowerCase())) {
                return additionalService;
            }
        }
        return null;
    }

    @Override
    public TAdditionalService save(TAdditionalService additionalService) {
        return this.repository.save(additionalService);
    }
}
