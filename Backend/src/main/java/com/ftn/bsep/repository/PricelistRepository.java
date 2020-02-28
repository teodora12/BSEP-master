package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

    Pricelist findPricelistById(Long id);

}
