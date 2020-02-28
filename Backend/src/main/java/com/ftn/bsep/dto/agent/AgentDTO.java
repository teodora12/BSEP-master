package com.ftn.bsep.dto.agent;

import com.ftn.bsep.model.modelGenerated.Address;
import lombok.Data;

@Data
public class AgentDTO {

    private  Long id;
    private String name;
    private String surname;
    private Address address;
    private int companyNumber;
    private  String username;
    private String email;
    private String password;


}
