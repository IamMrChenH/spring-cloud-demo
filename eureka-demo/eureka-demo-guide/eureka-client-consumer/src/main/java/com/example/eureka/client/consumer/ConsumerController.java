package com.example.eureka.client.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("consumer")
    public String consumer() {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client-server");
        System.out.println(instance);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/info";
        return restTemplate.getForObject(url, String.class);
    }


}
