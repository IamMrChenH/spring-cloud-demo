package com.example.eureka.client.ribbon;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chen
 */
@EnableHystrix
@EnableSwagger2Doc
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientRibbonHystrixApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientRibbonHystrixApplication.class)
                .web(true)
                .run(args);
    }

}
