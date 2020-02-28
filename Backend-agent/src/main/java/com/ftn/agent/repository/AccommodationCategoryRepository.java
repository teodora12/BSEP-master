package com.ftn.agent.repository;

import com.ftn.agent.model.TAccommodationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationCategoryRepository extends JpaRepository<TAccommodationCategory, Long> {

      TAccommodationCategory findTAccommodationCategoryById(Long id);
  //  TAccommodationCategory findTAccommodationCategorieBy(Long id);

}
