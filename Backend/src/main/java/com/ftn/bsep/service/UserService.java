package com.ftn.bsep.service;

import com.ftn.bsep.dto.user.BasicUserDto;
import com.ftn.bsep.dto.user.RegisterUserDto;
import com.ftn.bsep.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<BasicUserDto> getAllUsers();
    List<User> findAll();
    User findUserByMail (String email);
    BasicUserDto getUserByEmail(String email);
    BasicUserDto register(RegisterUserDto user);
    List<BasicUserDto> getSistems();
    List<BasicUserDto> getUsersWithoutValidCertificate ();
    User save(User user);
    User findUserByUsername(String username);
    BasicUserDto updateUser(BasicUserDto user);
}
