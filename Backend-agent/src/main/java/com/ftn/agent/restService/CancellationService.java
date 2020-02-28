package com.ftn.agent.restService;

import com.ftn.agent.model.TCancellation;
import org.springframework.stereotype.Service;

@Service
public interface CancellationService {

    TCancellation save(TCancellation cancellation);
    TCancellation findCancellationById (Long id);
}
