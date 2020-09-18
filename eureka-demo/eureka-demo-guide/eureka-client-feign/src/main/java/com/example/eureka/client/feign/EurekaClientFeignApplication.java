package com.example.eureka.client.feign;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author chen
 */
@EnableSwagger2Doc
@EnableFeignClients(basePackageClasses = ClientService.class)
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientFeignApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientFeignApplication.class)
                .web(true)
                .run(args);
    }

}
