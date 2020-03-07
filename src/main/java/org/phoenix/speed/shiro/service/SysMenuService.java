package org.phoenix.speed.shiro.service;

import org.phoenix.speed.shiro.pojo.po.SysMenu;
import org.phoenix.speed.shiro.pojo.po.SysRole;
import org.phoenix.speed.shiro.pojo.po.SysRoleMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 根据用户名查找用户权限集
     * @param username 用户名
     * @return 用户权限集合
     */
    List<SysMenu> selectUserPermission(String username);


}