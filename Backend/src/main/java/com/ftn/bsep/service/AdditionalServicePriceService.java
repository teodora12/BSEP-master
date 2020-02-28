package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.TAdditionalServicesWithPrices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdditionalServicePriceService {

     TAdditionalServicesWithPrices findServiceById(Long id);
     List<TAdditionalServicesWithPrices> saveAll(List<TAdditionalServicesWithPrices> tAdditionalServicesWithPrices);
}
