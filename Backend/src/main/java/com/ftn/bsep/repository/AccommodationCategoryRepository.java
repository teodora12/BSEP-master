package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.TAccommodationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationCategoryRepository extends JpaRepository<TAccommodationCategory, Long> {

  //  TAccommodationCategory findTAccommodationCategorieBy(Long id);

}
