package com.example.zookeeper.server.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZookeeperServerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerFeignApplication.class, args);
    }

}
