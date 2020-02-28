package com.ftn.agent.restService;

import com.ftn.agent.model.TAdditionalServicesWithPrices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdditionalServicePriceService {

     TAdditionalServicesWithPrices findServiceById(Long id);
     List<TAdditionalServicesWithPrices> saveAll(List<TAdditionalServicesWithPrices> additionalServicesWithPrices);
     TAdditionalServicesWithPrices save(TAdditionalServicesWithPrices additionalServicesWithPrices);
     void remove(TAdditionalServicesWithPrices additionalServicesWithPrices);
}
