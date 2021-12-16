package com.itranlin.basic.core.vo.account;

import com.itranlin.basic.core.vo.user.UserVO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author itranlin
 */
@Data
@ApiModel(value = "登录结果")
public class SignInVO {
    @ApiModelProperty("凭证")
    private String authorization;
    private UserVO userInfo;
}
