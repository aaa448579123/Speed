package org.phoenix.speed.domain.service;

import org.phoenix.speed.domain.pojo.po.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 根据username查找用户角色
     * @param userName 用户名
     * @return
     */
    public List<SysRole> selectUserRole(String userName);

    /**
     * 新增角色数据
     * @param sysRole 角色对象
     * @return
     */
    int addRole(SysRole sysRole);

}