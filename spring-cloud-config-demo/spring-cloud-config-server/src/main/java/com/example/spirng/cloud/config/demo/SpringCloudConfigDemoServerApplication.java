package com.example.spirng.cloud.config.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author chen
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigDemoServerApplication.class, args);
    }

}
