package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.Pricelist;
import com.ftn.agent.repository.PricelistRepository;
import com.ftn.agent.restService.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public Pricelist save(Pricelist pricelist) {
        return this.pricelistRepository.save(pricelist);
    }

    @Override
    public Pricelist findPricelistById(Long id) {
        return this.pricelistRepository.findPricelistById(id);
    }
}
