package org.phoenix.speed.domain.service;

import org.phoenix.speed.domain.pojo.po.SysRoleMenu;

public interface SysRoleMenuService {

    /**
     * 新增角色菜单数据
     * @param sysRoleMenu 角色菜单对象
     * @return
     */
    int addRoleMenu(SysRoleMenu sysRoleMenu);

}