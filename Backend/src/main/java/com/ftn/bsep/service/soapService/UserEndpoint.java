package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.Role;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.repository.RoleRepository;
import com.ftn.bsep.service.AddressService;
import com.ftn.bsep.service.AgentService;
import com.ftn.bsep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/user";

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AgentService agentService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegisterAgentRequest")
    @ResponsePayload
    public RegisterAgentResponse register(@RequestPayload RegisterAgentRequest request) {

        RegisterAgentResponse response = new RegisterAgentResponse();

        boolean exist = false;
        List<com.ftn.bsep.model.User> allUsers = this.userService.findAll();
        for(com.ftn.bsep.model.User u: allUsers){
            if(u.getEmail().equals(request.getUser().getEmail())){
                exist = true;
            }
        }

        if(exist == true){
            response.setSuccess(false);
            return response;
        }

        Address address = new Address(request.getUser().getAddress());

        this.addressService.save(address);

        com.ftn.bsep.model.User user = new com.ftn.bsep.model.User(request.getUser());
        user.setAddress(address);
        user.setEnabled(true);

//        Role role = this.roleRepository.findRoleByName(request.getUser().getRole());
//        List<Role> authorities = new ArrayList<>();
//        authorities.add(role);
//        user.setRoles(authorities);

   //     this.userService.save(user);


        Agent agent = new Agent(user);

        this.agentService.save(agent);

        response.setSuccess(true);

        return response;
    }

}
