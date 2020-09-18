package com.example.eureka.client.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class FeignController {

    @Autowired
    private ClientService clientService;


    @GetMapping("info")
    public String info() {
        return clientService.info();
    }

}
