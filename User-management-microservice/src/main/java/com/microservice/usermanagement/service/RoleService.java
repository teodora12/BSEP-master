package com.microservice.usermanagement.service;

import com.microservice.usermanagement.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role findByName(String name);
}
