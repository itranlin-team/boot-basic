package com.itranlin.basic.core.dto.user;

import com.itranlin.basic.core.dto.SplitPageDTO;
import com.itranlin.basic.core.entity.SysUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author itranlin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends SplitPageDTO<SysUser> {
    @ApiModelProperty("真实姓名")
    private String name;
}
