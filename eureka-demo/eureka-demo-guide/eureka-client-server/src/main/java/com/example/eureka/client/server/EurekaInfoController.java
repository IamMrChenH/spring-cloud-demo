package com.example.eureka.client.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class EurekaInfoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("info")
    public String getServiceInfo() {
        List<String> services = discoveryClient.getServices();
        return "services: " + services;
    }
}
