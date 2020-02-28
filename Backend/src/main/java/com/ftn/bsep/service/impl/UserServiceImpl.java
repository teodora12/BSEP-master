package com.ftn.bsep.service.impl;

import com.ftn.bsep.dto.user.BasicUserDto;
import com.ftn.bsep.dto.user.RegisterUserDto;
import com.ftn.bsep.model.Role;
import com.ftn.bsep.model.Certificate;
import com.ftn.bsep.model.State;
import com.ftn.bsep.model.User;
import com.ftn.bsep.repository.RoleRepository;
import com.ftn.bsep.repository.CertificateRepository;
import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.CertificateService;
import com.ftn.bsep.service.UserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private CertificateService certificateService;


    private static final Argon2 ARGON2 = Argon2Factory.create();

    private static final int ITERATIONS = 2;
    private static final int MEMORY= 65536;
    private static final int PARALLELISM = 1;


    public String encode(final CharSequence rawPassword) {
        //hash returns already the encoded String
        final String hash = ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, rawPassword.toString());
        return hash;
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return ARGON2.verify(encodedPassword, rawPassword.toString());
    }

    @Override
    public List<BasicUserDto> getAllUsers() {


        List<User> users = this.userRepository.findAll();
        List<BasicUserDto> userDtos = new ArrayList<>();
        for (User s : users) {
            userDtos.add(new BasicUserDto(s));
        }

        return userDtos;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findUserByMail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    @Override           // Find all that are CA-s
    public List<BasicUserDto> getSistems() {

         List<User> sistems = new ArrayList<>();

        List<Certificate> certificates = this.certificateRepository.findAllByIsCA(true);
        for (Certificate certificate : certificates) {
            User user = certificate.getUser();
           if(certificate.getState().equals(State.valid)) {
                sistems.add(user);
            }
        }

        List<BasicUserDto> userDtos = new ArrayList<>();
        for (User s : sistems) {
            userDtos.add(new BasicUserDto(s));
        }

        return userDtos;
    }

    @Override
    public BasicUserDto getUserByEmail(String email) {

        return new BasicUserDto(this.userRepository.findUserByEmail(Encode.forHtml(email)));
    }

    @Override
    public BasicUserDto register(RegisterUserDto userDto) {

        RegularExpressions  regularExpressions = new RegularExpressions();

        boolean isEmailValid = regularExpressions.isEmailValid(userDto.getEmail());
        boolean isPasswordValid = regularExpressions.isPasswordValid(userDto.getPassword());
        boolean isNameValid = regularExpressions.isNameValid(userDto.getName());
        boolean isLastNameValid = regularExpressions.isNameValid(userDto.getLastName());

        boolean exist = false;
        List<User> allUsers = this.userRepository.findAll();
        for(User u: allUsers){
            if(u.getEmail().equals(userDto.getEmail())){
                exist = true;
            }
        }
        if(exist || !isEmailValid || !isPasswordValid || !isNameValid || !isLastNameValid ){
            return null;
        }else {

            User user = new User(userDto);
            user.setEnabled(true);
            user.setPassword(encode(userDto.getPassword()));
            Role role = this.roleRepository.findRoleByName("ROLE_USER");
            List<Role> authorities = new ArrayList<>();
            authorities.add(role);
            user.setRoles(authorities);
            user.setLastPasswordResetDate(new Timestamp(DateTime.now().getMillis()));
             return new BasicUserDto(this.userRepository.save(user));
        }
    }

    @Override
    public List<BasicUserDto> getUsersWithoutValidCertificate ()
    {
        List<User> users = userRepository.findAll();
        List<User> forDelete = new ArrayList<>();
        for(User u : users) {
            List<Certificate> certificates = certificateRepository.findCertificatesByUserId(u.getId());
            if(!certificates.isEmpty()){

                for (Certificate c : certificates) {
                    if (c.getState() == State.valid) {
                        forDelete.add(u);
                    }
                }
            }
        }
        users.removeAll(forDelete);

        List<BasicUserDto> userDtos = new ArrayList<>();
        for (User u : users) {
            userDtos.add(new BasicUserDto(u));
        }
        return userDtos;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByEmail(username);
    }

    @Override
    public BasicUserDto updateUser(BasicUserDto user) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isNameValid = regularExpressions.isNameValid(user.getName());
        boolean isLastNameValid = regularExpressions.isNameValid(user.getLastName());

        if(!(isNameValid || isLastNameValid)){
            return null;
        }

        User userFromDbo = this.userRepository.findUserByEmail(user.getEmail());

        userFromDbo.setName(user.getName());
        userFromDbo.setLastName(user.getLastName());
        User changedUser = this.userRepository.save(userFromDbo);
        return new BasicUserDto(changedUser);
    }

}
