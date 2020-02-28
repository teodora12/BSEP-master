package com.ftn.agent.controller;

import com.ftn.agent.model.Message;
import com.ftn.agent.model.User;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import com.ftn.agent.model.forDatabase.UserTokenState;
import com.ftn.agent.repository.AgentRepository;
import com.ftn.agent.restService.MessageService;

import com.ftn.agent.restService.restServiceImpl.CustomUserDetailsService;
import com.ftn.agent.security.TokenUtils;
import com.ftn.agent.security.auth.JwtAuthenticationRequest;
import com.ftn.agent.security.validation.RegularExpressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    @Autowired
    private TokenUtils tokenUtils;


    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AgentRepository agentRepository;





    @PostMapping(value = "/login")
    public ResponseEntity<String> createAuthenticationToken(@Valid @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        RegularExpressions regularExpressions = new RegularExpressions();

        boolean isEmailValid = regularExpressions.isEmailValid(authenticationRequest.getUsername());
//        boolean isPasswordValid = regularExpressions.isPasswordValid(authenticationRequest.getPassword());

        if(isEmailValid == false  ){
            //  || isPasswordValid == false
            return null;
        }
        else {



            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword());
            try {
                AgentForDatabase user1 = agentRepository.findAgentForDatabaseByEmail(authenticationRequest.getUsername());
                final Authentication authentication = authenticationManager.authenticate(token);





                // Ubaci username + password u kontext
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // Kreiraj token
                AgentForDatabase user = (AgentForDatabase) authentication.getPrincipal();
                String jwt = tokenUtils.generateToken(user);
                int expiresIn = tokenUtils.getExpiredIn();

                // new UserTokenState(jwt, expiresIn)
                // Vrati token kao odgovor na uspesno autentifikaciju
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization: Bearer", jwt);


                return ResponseEntity.ok().headers(headers).build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

    }

    @PostMapping(value = "/refresh")
    public ResponseEntity refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);
        String username = this.tokenUtils.getUsernameFromToken(token);
        AgentForDatabase user = (AgentForDatabase) this.userDetailsService.loadUserByUsername(username);


        if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
        } else {
            UserTokenState userTokenState = new UserTokenState();
            return ResponseEntity.badRequest().body(userTokenState);
        }
    }

//    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
//    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
//        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
//
//        Map<String, String> result = new HashMap<>();
//        result.put("result", "success");
//        return ResponseEntity.accepted().body(result);
//    }
//
//    static class PasswordChanger {
//        public String oldPassword;
//        public String newPassword;
//    }

}
