package com.ftn.agent.restService;

import com.ftn.agent.dto.RegisterDTO;
import com.ftn.agent.model.User;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

@Service
public interface UserService {
 //   User findUserByUsername(String username);
    User save(User user);
    User register(RegisterDTO registerDTO);
    User findUserByEmail(String email);
}
