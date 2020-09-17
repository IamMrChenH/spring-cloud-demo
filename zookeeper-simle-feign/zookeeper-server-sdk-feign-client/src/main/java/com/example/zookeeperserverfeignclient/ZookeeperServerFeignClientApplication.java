package com.example.zookeeperserverfeignclient;

import com.example.zookeeper.server.sdk.api.UserService;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chen
 */
@EnableSwagger2Doc
@EnableFeignClients(basePackageClasses = UserService.class)
@SpringBootApplication
public class ZookeeperServerFeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperServerFeignClientApplication.class, args);
    }
}
