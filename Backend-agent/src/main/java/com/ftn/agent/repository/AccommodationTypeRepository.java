package com.ftn.agent.repository;

import com.ftn.agent.model.TAccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<TAccommodationType, Long> {

    TAccommodationType findTAccommodationTypeById(Long id);
    //TAccommodationType findTAccommodationTypeBy(Long id);
}
