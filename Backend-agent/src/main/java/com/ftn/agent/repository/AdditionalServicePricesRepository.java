package com.ftn.agent.repository;

import com.ftn.agent.model.TAdditionalServicesWithPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServicePricesRepository extends JpaRepository<TAdditionalServicesWithPrices, Long> {

    TAdditionalServicesWithPrices findTAdditionalServicesWithPricesById(Long id);
}
