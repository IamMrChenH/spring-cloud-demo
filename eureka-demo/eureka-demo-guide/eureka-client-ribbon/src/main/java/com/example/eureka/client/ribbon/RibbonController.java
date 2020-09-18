package com.example.eureka.client.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class RibbonController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("info")
    public String info() {
        return restTemplate.getForObject("http://eureka-client-server/info", String.class);
    }


}
