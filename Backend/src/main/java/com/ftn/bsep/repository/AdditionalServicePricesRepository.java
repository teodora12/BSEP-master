package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.TAdditionalServicesWithPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServicePricesRepository extends JpaRepository<TAdditionalServicesWithPrices, Long> {

    TAdditionalServicesWithPrices findTAdditionalServicesWithPricesById(Long id);
}
