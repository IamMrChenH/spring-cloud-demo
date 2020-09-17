package com.example.zookeeper.server.sdk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author chenh
 * @date 2020年09月17日
 */
@Data
@ApiModel("用户DTO")
public class UserDTO {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("id")
    private String name;
    @ApiModelProperty("id")
    private String phone;
}
