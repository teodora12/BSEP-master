package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.TAdditionalServicesWithPrices;
import com.ftn.bsep.repository.AdditionalServicePricesRepository;
import com.ftn.bsep.service.AdditionalServicePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdditionalServicePriceServiceImpl implements AdditionalServicePriceService {


    @Autowired
    private AdditionalServicePricesRepository additionalServicePricesRepository;


    @Override
    public TAdditionalServicesWithPrices findServiceById(Long id) {
        TAdditionalServicesWithPrices tAdditionalServicesWithPrices = this.additionalServicePricesRepository.findTAdditionalServicesWithPricesById(id);
        if(tAdditionalServicesWithPrices == null) {
            return null;
        }
        return tAdditionalServicesWithPrices;
    }

    @Override
    public List<TAdditionalServicesWithPrices> saveAll(List<TAdditionalServicesWithPrices> tAdditionalServicesWithPrices) {

        return this.additionalServicePricesRepository.saveAll(tAdditionalServicesWithPrices);
    }

}
