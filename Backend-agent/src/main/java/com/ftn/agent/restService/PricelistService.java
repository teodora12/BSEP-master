package com.ftn.agent.restService;

import com.ftn.agent.model.Pricelist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PricelistService {

    Pricelist save(Pricelist pricelist);
    Pricelist findPricelistById(Long id);
}
