package com.ftn.bsep.repository;


import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<TAdditionalService,Long > {

   // TAdditionalService findTAdditionalServiceById(Long id);

}
