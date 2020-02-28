package com.ftn.bsep.service.impl;


import com.ftn.bsep.model.modelGenerated.TCancellation;
import com.ftn.bsep.repository.CancellationRepository;
import com.ftn.bsep.service.CancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellationServiceImpl implements CancellationService {


    @Autowired
    private CancellationRepository cancellationRepository;
    
    @Override
    public TCancellation save(TCancellation cancellation) {
        this.cancellationRepository.save(cancellation);
        
        return cancellation;
    }

    @Override
    public TCancellation findCancellationById(Long id) {
        return this.cancellationRepository.findTCancellationById(id);
    }


}
