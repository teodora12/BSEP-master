package com.ftn.bsep.service.impl;


import com.ftn.bsep.model.modelGenerated.Item;
import com.ftn.bsep.model.modelGenerated.Pricelist;
import com.ftn.bsep.repository.ItemRepository;
import com.ftn.bsep.repository.PricelistRepository;
import com.ftn.bsep.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private ItemRepository itemRepository;



    @Override
    public Pricelist save(Pricelist pricelist) {
        return this.pricelistRepository.save(pricelist);
    }

    @Override
    public Pricelist findPricelistById(Long id) {
        return this.pricelistRepository.findPricelistById(id);
    }
}
