package com.ftn.bsep.service;


import com.ftn.bsep.model.modelGenerated.TCancellation;
import org.springframework.stereotype.Service;

@Service
public interface CancellationService {
    
    TCancellation save(TCancellation cancellation);
    TCancellation findCancellationById(Long id);
}
