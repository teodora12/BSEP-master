package com.bsep.client_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientModuleApplication.class, args);
    }

}
