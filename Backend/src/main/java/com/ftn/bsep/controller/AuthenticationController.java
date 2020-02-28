package com.ftn.bsep.controller;

import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.security.TokenUtils;
import com.ftn.bsep.security.auth.JwtAuthenticationRequest;
import com.ftn.bsep.model.User;
import com.ftn.bsep.model.UserTokenState;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
    private UserRepository userRepository;





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
                User user1 = userRepository.findUserByEmail(authenticationRequest.getUsername());
                final Authentication authentication = authenticationManager.authenticate(token);





                // Ubaci username + password u kontext
                SecurityContextHolder.getContext().setAuthentication(authentication);

                // Kreiraj token
                User user = (User) authentication.getPrincipal();
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
        User user = (User) this.userDetailsService.loadUserByUsername(username);


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
