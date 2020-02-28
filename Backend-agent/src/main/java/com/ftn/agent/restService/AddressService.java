package com.ftn.agent.restService;

import com.ftn.agent.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    public Address save(Address address);
    Address findAddressById(Long id);

}
