package com.ftn.agent.repository;

import com.ftn.agent.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

    Pricelist findPricelistById(Long id);

}
