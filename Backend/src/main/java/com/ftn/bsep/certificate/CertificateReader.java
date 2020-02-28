package com.ftn.bsep.certificate;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.Iterator;
@Log4j2
public class CertificateReader {
    public static final String BASE64_ENC_CERT_FILE = "./data/jovan2.cer";
    public static final String BIN_ENC_CERT_FILE = "./data/jovan1.cer";

    public void testIt() {
        readFromBase64EncFile();
        readFromBinEncFile();
    }


    private void readFromBase64EncFile() {
        try {
            FileInputStream fis = new FileInputStream(BASE64_ENC_CERT_FILE);
            BufferedInputStream bis = new BufferedInputStream(fis);

            CertificateFactory cf = CertificateFactory.getInstance("X.509");

            //Cita sertifikat po sertifikat
            //Svaki certifikat je izmedju
            //-----BEGIN CERTIFICATE-----,
            //i
            //-----END CERTIFICATE-----.
            while (bis.available() > 0) {
                cf.generateCertificate(bis);
            }
        } catch (CertificateException | IOException e) {
            log.error(e);
        }
    }
    @SuppressWarnings("rawtypes")
    private void readFromBinEncFile() {
        try {
            FileInputStream fis = new FileInputStream(BIN_ENC_CERT_FILE);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            //Ovde se vade svi sertifkati
            Collection c = cf.generateCertificates(fis);
            Iterator i = c.iterator();
            while (i.hasNext()) {
                Certificate cert = (Certificate)i.next();
            }
        } catch (FileNotFoundException | CertificateException e) {
            log.error(e);
        }

    }

    public static void main(String[] args) {
        CertificateReader test = new CertificateReader();
        test.testIt();
    }
}
