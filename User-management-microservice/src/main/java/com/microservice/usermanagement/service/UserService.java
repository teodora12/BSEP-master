package com.microservice.usermanagement.service;

import com.microservice.usermanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User findOne(Long id);
    List<User> findAll();
    User save(User user);
    void delete(User user);
    User findByEmail(String email);
}
