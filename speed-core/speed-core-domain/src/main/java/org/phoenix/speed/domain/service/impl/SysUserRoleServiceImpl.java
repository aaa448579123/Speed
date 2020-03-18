package org.phoenix.speed.domain.service.impl;

import org.phoenix.speed.domain.dao.SysUserRoleMapper;
import org.phoenix.speed.domain.pojo.po.SysUserRole;
import org.phoenix.speed.domain.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    /**
     * 新增用户角色数据
     * @param sysUserRole 用户角色对象
     * @return
     */
    @Override
    public int addUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insertSelective(sysUserRole);
    }
}
