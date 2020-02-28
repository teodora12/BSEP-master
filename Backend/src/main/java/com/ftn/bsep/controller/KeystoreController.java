package com.ftn.bsep.controller;

import com.ftn.bsep.certificate.keystore.KeyStoreWriter;
import com.ftn.bsep.dto.keystore.NewKeystoreDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController

@Log4j2
@RequestMapping(value = "/api/keystore", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeystoreController {

    @PostMapping(value = "/generate")
    @PreAuthorize("hasAuthority('WRITE_KEYSTORE')")
    public ResponseEntity generate(@Valid @RequestBody NewKeystoreDto keystoreDto)  {

        KeyStoreWriter keyStoreWriter = new KeyStoreWriter();
        keyStoreWriter.loadKeyStore(null, keystoreDto.getPassword().toCharArray());
        keyStoreWriter.saveKeyStore(keystoreDto.getName()+".jks", keystoreDto.getPassword().toCharArray());

        log.info("Keystore "+ keystoreDto.getName()+" successfully generated.");
        return ResponseEntity.ok().build();

    }

}
