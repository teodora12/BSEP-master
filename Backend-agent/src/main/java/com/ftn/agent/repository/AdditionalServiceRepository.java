package com.ftn.agent.repository;


import com.ftn.agent.model.TAdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<TAdditionalService,Long > {

    TAdditionalService findTAdditionalServiceById(Long id);
   // TAdditionalService findTAdditionalServiceById(Long id);

}
