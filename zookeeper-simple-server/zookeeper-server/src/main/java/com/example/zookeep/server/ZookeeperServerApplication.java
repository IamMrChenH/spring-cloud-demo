package com.example.zookeep.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerApplication.class, args);
    }

}
