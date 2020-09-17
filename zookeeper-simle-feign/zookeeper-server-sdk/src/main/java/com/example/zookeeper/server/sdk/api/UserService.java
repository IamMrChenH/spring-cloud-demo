package com.example.zookeeper.server.sdk.api;

import com.example.zookeeper.server.sdk.dto.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenh
 * @date 2020年09月17日
 */
@Api(value = "测试接口", tags = "测试接口")
@FeignClient(name = "zookeeper-server-feign", serviceId = "zookeeper-server-feign")
@RequestMapping("/v1/user_sdk")
public interface UserService {

    /**
     * 根据用户名称-查询用户详情
     *
     * @param name 用户名称
     * @return
     */
    @GetMapping("name/{name}")
    UserDTO findByName(@PathVariable("name") String name);

}
