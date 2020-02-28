package com.ftn.bsep.service.impl;

import com.ftn.bsep.model.modelGenerated.Address;
import com.ftn.bsep.repository.AddressRepository;
import com.ftn.bsep.service.AddressService;
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
        return this.addressRepository.findAddressById(id);
    }

}
