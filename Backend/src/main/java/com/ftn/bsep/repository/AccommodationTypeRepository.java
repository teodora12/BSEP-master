package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<TAccommodationType, Long> {

    //TAccommodationType findTAccommodationTypeBy(Long id);
}
