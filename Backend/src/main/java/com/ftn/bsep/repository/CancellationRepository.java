package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.TAccommodationType;
import com.ftn.bsep.model.modelGenerated.TCancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRepository extends JpaRepository<TCancellation, Long> {

    TCancellation findTCancellationById(Long id);
}
