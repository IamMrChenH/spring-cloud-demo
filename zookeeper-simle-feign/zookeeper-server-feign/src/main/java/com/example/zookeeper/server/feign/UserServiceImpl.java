package com.example.zookeeper.server.feign;

import com.example.zookeeper.server.sdk.api.UserService;
import com.example.zookeeper.server.sdk.dto.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenh
 * @date 2020年09月17日
 */
@RestController("com.example.zookeeper.server.feign.UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findByName(String name) {
        UserDTO user = new UserDTO();
        user.setId(Long.valueOf(RandomStringUtils.randomNumeric(3)));
        user.setName(name);
        user.setPhone(RandomStringUtils.randomNumeric(11));
        return user;
    }
}
