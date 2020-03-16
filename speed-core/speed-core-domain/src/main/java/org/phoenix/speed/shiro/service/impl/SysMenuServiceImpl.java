package org.phoenix.speed.shiro.service.impl;

import org.phoenix.speed.shiro.dao.SysMenuMapper;
import org.phoenix.speed.shiro.pojo.po.SysMenu;
import org.phoenix.speed.shiro.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户名查找用户权限集
     * @param username 用户名
     * @return
     */
    @Override
    public List<SysMenu> selectUserPermission(String username) {
        return sysMenuMapper.selectUserPermission(username);
    }



}
