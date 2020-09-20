package com.example.eureka.client.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenh
 * @date 2020/9/20
 */
@Service
public class RibbonService {


    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String info() {
        return restTemplate.getForObject("http://eureka-client-server/info", String.class);
    }

    public String fallback() {
        return "fallback";
    }

}
