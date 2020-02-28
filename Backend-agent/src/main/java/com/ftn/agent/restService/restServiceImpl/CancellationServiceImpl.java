package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.TCancellation;
import com.ftn.agent.repository.CancellationRepository;
import com.ftn.agent.restService.CancellationService;
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
        return cancellationRepository.findTCancellationById(id);
    }


}
