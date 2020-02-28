package com.microservice.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    Accommodation findAccommodationById(Long id);
}
