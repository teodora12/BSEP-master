package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdditionalServiceService {

    List<TAdditionalService> findAll();
    TAdditionalService findOne(Long id);
    TAdditionalService save(TAdditionalService additionalService);
    void delete(TAdditionalService additionalService);
    TAdditionalService findByName(String name);
}
