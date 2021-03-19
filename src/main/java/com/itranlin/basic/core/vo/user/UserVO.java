package com.itranlin.basic.core.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author itranlin
 */
@Data
@ApiModel(value = "用户信息")
public class UserVO {
    private String id;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("角色")
    private String type;
}
