package org.phoenix.speed.shiro.service.impl;

import org.phoenix.speed.shiro.dao.SysRoleMenuMapper;
import org.phoenix.speed.shiro.pojo.po.SysRoleMenu;
import org.phoenix.speed.shiro.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;

public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 新增角色菜单对象
     * @param sysRoleMenu 角色菜单对象
     * @return
     */
    @Override
    public int addRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.insertSelective(sysRoleMenu);
    }
}
