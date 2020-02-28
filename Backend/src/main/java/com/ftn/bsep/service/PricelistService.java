package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.Item;
import com.ftn.bsep.model.modelGenerated.Pricelist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PricelistService {

    Pricelist save(Pricelist pricelist);
    Pricelist findPricelistById(Long id);

}
