package com.ftn.bsep.controller;

import com.ftn.bsep.dto.agent.AgentDTO;
import com.ftn.bsep.dto.agent.AddAgentDTO;
import com.ftn.bsep.dto.user.BasicUserDto;
import com.ftn.bsep.dto.user.RegisterUserDto;
import com.ftn.bsep.model.User;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private RestTemplate restTemplate;

    private static final String USER_SERVICE_URI= "https://localhost:8083/api/agents/addAgent";

    private static final String DELETEA_SERVICE_URI= "https://localhost:8083/api/agents/delete";
    private static final String DELETEU_SERVICE_URI= "https://localhost:8083/api/userManagement/delete";
    private static final String ACTIVATE_SERVICE_URI= "https://localhost:8083/api/userManagement/activate-user";
    private static final String BLOCK_URI= "https://localhost:8083/api/userManagement/block-user";




    @PostMapping(value = "/register")
    public ResponseEntity<BasicUserDto> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto) throws InterruptedException {
        BasicUserDto user = this.userService.register(registerUserDto);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/{email}")
    public BasicUserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping(value = "/systems")
 //   @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<BasicUserDto>> allCASystems()  {
        List<BasicUserDto> systems = this.userService.getSistems();
        if(systems == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(systems, HttpStatus.OK);
    }

    @GetMapping(value = "/withoutValid")
 //   @PreAuthorize("hasRole('ROLE_SISTEM')")
    public ResponseEntity<List<BasicUserDto>> getUsersWithoutValidCertificate() {
        List<BasicUserDto> users = this.userService.getUsersWithoutValidCertificate();
        if(users == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping(value = "/addAgent")
    public ResponseEntity addAgent(@RequestBody AddAgentDTO agent) {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //  requestHeaders.add("Authorization", authorization);

        HttpEntity requestEntity = new HttpEntity<>(agent, requestHeaders);

        ResponseEntity resp = restTemplate.exchange(USER_SERVICE_URI, HttpMethod.POST,requestEntity, AgentDTO.class);
        return new ResponseEntity(resp.getBody(), HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteAgent/{id}")
    public ResponseEntity deleteAgent(@PathVariable Long id){
        String entityUrl = DELETEA_SERVICE_URI + "/" + id;
        restTemplate.delete(entityUrl);
        return new ResponseEntity( HttpStatus.OK);


    }

    @DeleteMapping(value="/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        String entityUrl = DELETEU_SERVICE_URI + "/" + id;
        restTemplate.delete(entityUrl);
        return new ResponseEntity( HttpStatus.OK);


    }

    @PutMapping(value = "/block/{id}")
    public ResponseEntity block(@PathVariable Long id){
        String entityUrl = BLOCK_URI + "/" + id;
        restTemplate.put(entityUrl,null);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/activate/{id}")
    public ResponseEntity activate(@PathVariable Long id){
        String entityUrl = ACTIVATE_SERVICE_URI + "/" + id;
        restTemplate.put(entityUrl,null);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     *  Za obicnog usera, menja samo ime i prezome
     * */
    @PreAuthorize("hasAuthority('CHANGE_NAME_AND_LAST_NAME')")
    @PutMapping
    public ResponseEntity updateUser(@Valid @RequestBody BasicUserDto user) {

        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isEmailValid = regularExpressions.isEmailValid(user.getEmail());
        if(isEmailValid  == false){
            return new ResponseEntity<>("Email is not valid!", HttpStatus.FORBIDDEN);
        }
        BasicUserDto savedUser = this.getUserByEmail(user.getEmail());
        if (savedUser == null) {
            return ResponseEntity.notFound().build();
        }
        savedUser = this.userService.updateUser(user);
        if(savedUser == null) {
            return new ResponseEntity<>("Email is not valid!", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok(savedUser);
    }


}
