package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.TAdditionalServicesWithPrices;
import com.ftn.agent.repository.AdditionalServicePricesRepository;
import com.ftn.agent.restService.AdditionalServicePriceService;
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
    public List<TAdditionalServicesWithPrices> saveAll(List<TAdditionalServicesWithPrices> additionalServicesWithPrices) {
        return this.additionalServicePricesRepository.saveAll(additionalServicesWithPrices);
    }

    @Override
    public TAdditionalServicesWithPrices save(TAdditionalServicesWithPrices additionalServicesWithPrices) {
        return this.additionalServicePricesRepository.save(additionalServicesWithPrices);
    }

    @Override
    public void remove(TAdditionalServicesWithPrices additionalServicesWithPrices) {
        this.additionalServicePricesRepository.delete(additionalServicesWithPrices);
    }

}
