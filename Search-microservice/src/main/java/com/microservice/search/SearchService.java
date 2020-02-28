package com.microservice.search;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface SearchService {

    Set search(AccommodationSearchDto accommodationSearchDto);
}
