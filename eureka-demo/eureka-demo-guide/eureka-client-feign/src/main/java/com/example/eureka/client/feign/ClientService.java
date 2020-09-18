package com.example.eureka.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chenh
 * @date 2020年09月18日
 */
@FeignClient("eureka-client-server")
public interface ClientService {

    /**
     * d
     *
     * @return
     */
    @GetMapping("info")
    String info();

}
