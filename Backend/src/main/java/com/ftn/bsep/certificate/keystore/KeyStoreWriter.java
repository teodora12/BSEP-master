package com.ftn.bsep.certificate.keystore;

import com.ftn.bsep.exception.KeystoreAccessException;
import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
@Log4j2
public class KeyStoreWriter {

   /** KeyStore je Java klasa za citanje specijalizovanih datoteka koje se koriste za cuvanje kljuceva
    * Tri tipa entiteta koji se obicno nalaze u ovakvim datotekama su:
    *      - Sertifikati koji ukljucuju javni kljuc
    *      - Privatni kljucevi
    *      - Tajni kljucevi, koji se koriste u simetricnima siframa
    */
    private KeyStore keyStore;

    public KeyStoreWriter() {
        try {
            keyStore = KeyStore.getInstance("JKS", "SUN");
        } catch (KeyStoreException | NoSuchProviderException e) {
            log.error("Error while accessing keystore");
            throw new KeystoreAccessException();
        }
    }

    public void loadKeyStore(String fileName, char[] password) {
        try {
            if(fileName != null) {
                keyStore.load(new FileInputStream(fileName), password);
            } else {
                //Ako je cilj kreirati novi KeyStore poziva se i dalje load, pri cemu je prvi parametar null
                keyStore.load(null, password);
            }
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            log.error("Error while loading keystore");
            throw new KeystoreAccessException();
        }
    }

    public void saveKeyStore(String fileName, char[] password) {
        try {
            keyStore.store(new FileOutputStream(fileName), password);
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            log.error("Error while accessing or saving keystore");
            throw new KeystoreAccessException();
        }
    }

    public void write(String alias, PrivateKey privateKey, char[] password, Certificate certificate) {
        try {
        keyStore.setKeyEntry(alias, privateKey, password, new Certificate[] {certificate});

        } catch (KeyStoreException e) {
            log.error("Error while writing in keystore");
            throw new KeystoreAccessException();
        }
    }
}
