package com.itranlin.basic.core.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itranlin.basic.core.bean.RequestResult;
import com.itranlin.basic.core.bean.StatusEnum;
import com.itranlin.basic.core.dto.PwdDTO;
import com.itranlin.basic.core.dto.UserCommitDTO;
import com.itranlin.basic.core.dto.UserDTO;
import com.itranlin.basic.core.service.ISysUserService;
import com.itranlin.basic.core.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author CY
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/api/sys-user")
@Api(tags = {"用户相关"})
public class SysUserController {
    @Resource
    private ISysUserService userService;
    @PostMapping(value = "/list")
    @ApiOperation(value = "用户列表")
    public RequestResult<IPage<UserVO>> list(@RequestBody UserDTO userDTO) {
        return RequestResult.e(StatusEnum.OK,userService.userPage(userDTO));
    }

    @PostMapping(value = "/commit")
    @ApiOperation(value = "新增用户")
    public RequestResult<IPage<UserVO>> commit(@RequestBody UserCommitDTO user) {
        userService.commit(user);
        return RequestResult.e(StatusEnum.OK);
    }

    @GetMapping(value = "/remove/{id}")
    @ApiOperation(value = "删除用户")
    public RequestResult<Void> remove(@PathVariable String id) {
        userService.removeById(id);
        return RequestResult.e(StatusEnum.OK);
    }

    @PostMapping(value = "/pwd")
    @ApiOperation(value = "修改密码")
    public RequestResult<Void> pwd(@RequestBody @Validated PwdDTO pwdDTO) {
        userService.pwd(pwdDTO);
        return RequestResult.e(StatusEnum.OK);
    }

}
