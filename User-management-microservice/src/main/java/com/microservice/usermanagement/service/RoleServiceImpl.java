package com.microservice.usermanagement.service;

import com.microservice.usermanagement.model.Role;
import com.microservice.usermanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository repository;


    @Override
    public Role findByName(String name){
        for (Role u : repository.findAll()) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }


}
