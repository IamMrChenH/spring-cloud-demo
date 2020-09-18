package com.example.spirng.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author chen
 */
@SpringBootApplication
public class SpringCloudConfigDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigDemoServerApplication.class, args);
    }

    @Value("${ZZZZZ}")
    public String temp;

    @PostConstruct
    public void print() {
        System.out.println(temp);
    }

}
