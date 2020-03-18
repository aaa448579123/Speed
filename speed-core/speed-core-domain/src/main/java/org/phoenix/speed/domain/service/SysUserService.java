package org.phoenix.speed.domain.service;

import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.pojo.vo.SysUserVO;

public interface SysUserService {
    /**
     * 根据username查找用户信息
     * @param username 用户名
     * @return
     */
    SysUserVO selectByUserName(String username);

    /**
     * 新增用户数据
     * @param sysUser 用户对象
     * @return
     */
    int addUser(SysUser sysUser);
}