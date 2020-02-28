package com.ftn.agent.repository;

import com.ftn.agent.model.TCancellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRepository extends JpaRepository<TCancellation, Long> {

    TCancellation findTCancellationById(Long id);
}
