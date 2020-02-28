package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.model.Address;
import com.ftn.agent.repository.AddressRepository;
import com.ftn.agent.restService.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        this.addressRepository.save(address);
        return address;
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findAddressById(id);
    }

}
