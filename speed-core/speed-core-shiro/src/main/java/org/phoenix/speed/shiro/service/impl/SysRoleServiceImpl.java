package org.phoenix.speed.shiro.service.impl;

import org.phoenix.speed.shiro.dao.SysRoleMapper;
import org.phoenix.speed.shiro.pojo.po.SysRole;
import org.phoenix.speed.shiro.service.SysRoleService;
import org.phoenix.speed.shiro.service.SysUserRoleService;
import org.phoenix.speed.shiro.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;



    /**
     * 根据username查找用户角色
     * @param userName 用户名
     * @return
     */
    @Override
    public List<SysRole> selectUserRole(String userName) {
        return sysRoleMapper.selectUserRole(userName);
    }

    /**
     * 新增角色数据
     * @param sysRole 角色对象
     * @return
     */
    @Override
    public int addRole(SysRole sysRole) {
        sysRole.setRoleId(CommonUtil.uuid());
        sysRole.setCreateTime(new Date());
        return sysRoleMapper.insertSelective(sysRole);
    }


}
