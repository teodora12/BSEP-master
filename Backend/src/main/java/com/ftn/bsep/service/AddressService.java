package com.ftn.bsep.service;

import com.ftn.bsep.model.modelGenerated.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

     Address save(Address address);
     Address findAddressById(Long id);

}
