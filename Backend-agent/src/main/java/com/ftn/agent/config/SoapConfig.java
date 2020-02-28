package com.ftn.agent.config;

import com.ftn.agent.soapService.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@Configuration
public class SoapConfig {

    private String keyStorePassword="123";


    private String trustStorePassword="123";


    private HttpsUrlConnectionMessageSender httpsConfig() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        Path path = FileSystems.getDefault().getPath("keystore.jks");
        File file= new File(String.valueOf(path));
        InputStream is= new FileInputStream(file);

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is,keyStorePassword.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(ks, keyStorePassword.toCharArray());

        Path path1 = FileSystems.getDefault().getPath("keystore.jks");
        File file1= new File(String.valueOf(path1));
        InputStream is1= new FileInputStream(file1);

        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(is1, trustStorePassword.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(ts);

        HttpsUrlConnectionMessageSender messageSender = new HttpsUrlConnectionMessageSender();
        messageSender.setKeyManagers(keyManagerFactory.getKeyManagers());
        messageSender.setTrustManagers(trustManagerFactory.getTrustManagers());

        // otherwise: java.security.cert.CertificateException: No name matching localhost found
        messageSender.setHostnameVerifier((hostname, sslSession) -> {
            if (hostname.equals("localhost")) {
                return true;
            }
            return false;
        });

        return messageSender;
    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        //  marshaller.setContextPath("com.ftn.agent.model");
        marshaller.setPackagesToScan("com.ftn.agent.model");
        return marshaller;
    }

    @Bean
    public SOAPConnectorMessage soapConnectorMessage(Jaxb2Marshaller marshaller) throws Exception {
        SOAPConnectorMessage client = new SOAPConnectorMessage();
        client.setDefaultUri("http://192.168.43.156:8762/user-admin-service/ws/message");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        HttpsUrlConnectionMessageSender messageSender= httpsConfig();

        client.setMessageSender(messageSender);
        return client;
    }

    @Bean
    public SOAPConnectorAccommodation soapConnectorAccommodation(Jaxb2Marshaller marshaller) throws Exception {
        SOAPConnectorAccommodation client = new SOAPConnectorAccommodation();
        client.setDefaultUri("http://192.168.43.156:8762/user-admin-service/ws/accommodation");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        HttpsUrlConnectionMessageSender messageSender= httpsConfig();

        client.setMessageSender(messageSender);
        return client;
    }


    @Bean
    public SOAPConnectorReservation soapConnectorReservation(Jaxb2Marshaller marshaller) throws Exception {
        SOAPConnectorReservation client = new SOAPConnectorReservation();
        client.setDefaultUri("http://192.168.43.156:8762/user-admin-service/ws/accommodation");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        HttpsUrlConnectionMessageSender messageSender= httpsConfig();

        client.setMessageSender(messageSender);
        return client;
    }


    @Bean
    public SOAPConnectorAgent soapConnectorAgent(Jaxb2Marshaller marshaller) throws Exception {
        SOAPConnectorAgent client = new SOAPConnectorAgent();
        client.setDefaultUri("http://192.168.43.156:8762/user-admin-service/ws/agent");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        HttpsUrlConnectionMessageSender messageSender= httpsConfig();

        client.setMessageSender(messageSender);
        return client;
    }


    @Bean
    public SOAPConnectorUser soapConnectorUser(Jaxb2Marshaller marshaller) throws Exception {
        SOAPConnectorUser client = new SOAPConnectorUser();
        client.setDefaultUri("http://192.168.43.156:8762/user-admin-service/ws/user");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        HttpsUrlConnectionMessageSender messageSender= httpsConfig();

        client.setMessageSender(messageSender);
        return client;
    }

}
