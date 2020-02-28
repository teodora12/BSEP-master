package com.ftn.bsep.controller;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClients;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.KeyStore;

@RestController
public class HttpsController {

    private static final String SERVICE_URI= "https://localhost:8090/agent";
    private static final String PASSWORD="123";


    @RequestMapping("httpsController")
    public String demo() throws Exception {
        RestTemplate restTemplate= getRestTemplate();
        RequestEntity<Object> requestEntity= null;
        ResponseEntity<String> resp = restTemplate.exchange(SERVICE_URI,HttpMethod.GET,requestEntity, String.class);
        return resp.getStatusCode().toString()+ "poruka sa agenta je : " + resp.getBody().trim();
    }

    @SuppressWarnings("deprecation")
    public RestTemplate getRestTemplate() throws Exception{
        RestTemplate restTemplate= new RestTemplate();
        Path path = FileSystems.getDefault().getPath("jovana.jks");
        File file= new File(String.valueOf(path));
        InputStream is= new FileInputStream(file);
        KeyStore keyStore= KeyStore.getInstance("jks");
        keyStore.load(is,PASSWORD.toCharArray());

        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(keyStore).loadKeyMaterial(keyStore,PASSWORD.toCharArray()).build();
        HttpClient client = HttpClients.custom().setHostnameVerifier(SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER).setSSLContext(sslContext).build();


        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
        return restTemplate;
    }
}
