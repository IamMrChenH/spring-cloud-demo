package com.example.zookeeperserverfeignclient;

import com.example.zookeeper.server.sdk.api.UserService;
import com.example.zookeeper.server.sdk.dto.UserDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenh
 * @date 2020年09月17日
 */
@Slf4j
@Api(value = "远程连接server", tags = "远程连接server")
@RestController
@RequestMapping("/v1/client")
public class ClientController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String findByName(String name) {
        UserDTO user = userService.findByName(name);
        log.error("{}", user);
        return user.toString();
    }
}
