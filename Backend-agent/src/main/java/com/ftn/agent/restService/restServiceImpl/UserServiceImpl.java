package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.dto.RegisterDTO;
import com.ftn.agent.model.Address;
import com.ftn.agent.model.RegisterAgentResponse;
import com.ftn.agent.model.User;
import com.ftn.agent.repository.UserRepository;
import com.ftn.agent.restService.UserService;
import com.ftn.agent.security.validation.RegularExpressions;
import com.ftn.agent.soapService.SOAPConnectorUser;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private SOAPConnectorUser soapConnectorUser;


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
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User register(RegisterDTO registerDTO) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(registerDTO.getEmail());
        boolean isNameValid = regularExpressions.isNameValid(registerDTO.getName());
        boolean isSurenameValid = regularExpressions.isNameValid(registerDTO.getSurname());
        boolean isPasswordValid = regularExpressions.isPasswordValid(registerDTO.getPassword());
        boolean isAddressStreetValid = regularExpressions.isAddressValid(registerDTO.getAddressDTO().getStreet());
        boolean isAddressCountryValid = regularExpressions.isAddressValid(registerDTO.getAddressDTO().getCountry());
        boolean isAddressCityValid = regularExpressions.isAddressValid(registerDTO.getAddressDTO().getCity());
        boolean isAddrresStreetNumValid = regularExpressions.isStreetNumberValid(registerDTO.getAddressDTO().getStreetNumber().toString());
        boolean isAddressLongitudeValid = regularExpressions.isLongitudeAndLatitudeValid(registerDTO.getAddressDTO().getLongitude());
        boolean isAddressLatitudeValid = regularExpressions.isLongitudeAndLatitudeValid(registerDTO.getAddressDTO().getLatitude());

        if(!(isEmailValid && isNameValid && isSurenameValid && isPasswordValid && isAddressCityValid && isAddressCountryValid
                && isAddressLatitudeValid && isAddressLongitudeValid && isAddressStreetValid && isAddrresStreetNumValid ))
        {
            return null;
        }
        boolean exist = false;
        List<User> allUsers = this.userRepository.findAll();
        for(User u: allUsers){
            if(u.getEmail().equals(registerDTO.getEmail())){
                exist = true;
            }
        }

        if(exist == true){
            return null;
        }

        Address address = new Address(registerDTO.getAddressDTO());

        this.addressService.save(address);

        User user = new User(registerDTO);
        user.setAddress(address);
        user.setPassword(encode(registerDTO.getPassword()));


        RegisterAgentResponse response = this.soapConnectorUser.registerAgentRequest(user);

        if(response.isSuccess() == false){
            return  null;
        }


        this.userRepository.save(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }
}
