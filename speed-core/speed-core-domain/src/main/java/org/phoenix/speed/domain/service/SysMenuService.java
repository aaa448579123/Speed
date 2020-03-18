package org.phoenix.speed.domain.service;

import org.phoenix.speed.domain.pojo.po.SysMenu;

import java.util.List;

public interface SysMenuService {
    /**
     * 根据用户名查找用户权限集
     * @param username 用户名
     * @return 用户权限集合
     */
    List<SysMenu> selectUserPermission(String username);


}