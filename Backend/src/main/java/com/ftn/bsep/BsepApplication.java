package com.ftn.bsep;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.ftn.bsep.model.modelGenerated.GetMessagesRequest;
import com.ftn.bsep.model.modelGenerated.GetMessagesResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@EnableEurekaClient
@SpringBootApplication
public class BsepApplication {

    private static final String PASSWORD="123";

    public static void main(String[] args) {
        SpringApplication.run(BsepApplication.class, args);

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception{

        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);


        return restTemplate;
    }


//    @Bean
//    CommandLineRunner lookup(SOAPConnectorMessage soapConnectorMessage) {
//        return args -> {
//
//            GetMessagesRequest request = new GetMessagesRequest();
//            GetMessagesResponse response =(GetMessagesResponse) soapConnectorMessage.getMessageResponse(request.getUsername());
//            System.out.println("Got Response As below ========= : ");
//            System.out.println("Number of messages : "+response.getMessage().size());
//
//        };
//    }

}
