package com.example.eureka.client.consumer;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chen
 */
@EnableSwagger2Doc
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientConsumerApplication {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientConsumerApplication.class).web(true).run(args);
    }

}
