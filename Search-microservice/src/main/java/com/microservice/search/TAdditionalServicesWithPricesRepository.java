package com.microservice.search;

import com.microservice.search.model.TAdditionalService;
import com.microservice.search.model.TAdditionalServicesWithPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TAdditionalServicesWithPricesRepository extends JpaRepository<TAdditionalServicesWithPrices, Long> {

    @Query(value = "select * from tadditional_services_with_prices tadd " +
            "left join accommodation_additional_services_with_prices aaswp on tadd.id = aaswp.additional_services_with_prices_id " +
            "where aaswp.accommodation_id = :accommodation_id ", nativeQuery = true)
    List<TAdditionalServicesWithPrices> getServicesByAccommodation(@Param("accommodation_id") Long accommodation_id);


    // Vraca da li se prosledjeni id additional service-a nalazi u prosledjenom accommodation-u
    @Query(value = "select case when (:additional_service in (select t.id from tadditional_service t " +
            "left join tadditional_services_with_prices tswp on t.id = tswp.additional_services_id " +
            "left join accommodation_additional_services_with_prices aaswp on tswp.id = aaswp.additional_services_with_prices_id " +
            "where aaswp.accommodation_id = :accommodation_id)) then 'True' else 'False' end" , nativeQuery = true)
    boolean doesAccommodationHaveAdditionalService(@Param("accommodation_id") Long accommodation_id, @Param("additional_service") Long additionalService);
}
