package com.example.eureka.client.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@RestController
public class RibbonController {


    @Autowired
    private RibbonService ribbonService;

    @GetMapping("info")
    public String info() {
        return ribbonService.info();
    }


    @GetMapping("info1")
    public String info1() {
        return UUID.randomUUID().toString();
    }

}
