package com.itranlin.basic.core.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itranlin.basic.core.dto.PwdDTO;
import com.itranlin.basic.core.dto.SignDTO;
import com.itranlin.basic.core.dto.UserCommitDTO;
import com.itranlin.basic.core.dto.UserDTO;
import com.itranlin.basic.core.entity.SysUser;
import com.itranlin.basic.core.vo.SignInVO;
import com.itranlin.basic.core.vo.UserVO;

/**
 * @author CY
 * @since 2020-03-15
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 登录
     * @param signDTO 登录数据
     * @return 登录结果数据
     */
    SignInVO signIn(SignDTO signDTO);


    /**
     * 刷新凭证
     * @return 登录结果数据
     */
    SignInVO refresh();



    /**
     * 用户分页
     * @param userDTO 查询数据
     * @return 分页结果
     */
    IPage<UserVO> userPage(UserDTO userDTO);

    /**
     * 提交数据
     * @param commitDTO 提交数据
     */
    void commit(UserCommitDTO commitDTO);

    /**
     * 修改密码
     * @param pwdDTO 提交数据
     */
    void pwd(PwdDTO pwdDTO);



}
