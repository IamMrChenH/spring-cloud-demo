package com.example.eureka.client.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chen
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EurekaClientServerApplication.class, args);
        new SpringApplicationBuilder(EurekaClientServerApplication.class)
                .web(true).run(args);
    }

}
