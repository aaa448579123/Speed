package org.phoenix.speed.controller;

import org.phoenix.speed.exception.RestApi;
import org.phoenix.speed.exception.RestResult;
import org.phoenix.speed.shiro.pojo.po.SysRole;
import org.phoenix.speed.shiro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RestApi
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 新增角色
     * @param role 角色
     * @return
     */
    @PostMapping
//    @RequiresPermissions("role:add")
    public RestResult addUser(@RequestBody SysRole role){
        int sur = sysRoleService.addRole(role);
        return RestResult.success();
    }
}
