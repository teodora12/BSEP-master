package com.ftn.agent.restService;


import com.ftn.agent.model.TAdditionalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdditionalServiceService {

    List<TAdditionalService> findAll();
    TAdditionalService findOne(Long id);
    TAdditionalService findByName(String name);
    TAdditionalService save(TAdditionalService additionalService);
}
