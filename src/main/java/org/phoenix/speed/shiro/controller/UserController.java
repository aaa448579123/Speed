package org.phoenix.speed.shiro.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.phoenix.speed.controller.RestApi;
import org.phoenix.speed.controller.RestResult;
import org.phoenix.speed.shiro.pojo.po.SysUser;
import org.phoenix.speed.shiro.pojo.po.SysUserRole;
import org.phoenix.speed.shiro.pojo.vo.SysUserVO;
import org.phoenix.speed.shiro.service.SysUserRoleService;
import org.phoenix.speed.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RestApi
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;


    /**
     * 初始登录
     * @return
     */
    @GetMapping("/common/login")
    public RestResult login(){
        String userName = "admin";
        String password = "123456";

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        SecurityUtils.getSubject().login(token);
        return RestResult.success("登录成功");
    }

    /**
     * 新增用户
     * @param user 用户
     * @return
     */
    @PostMapping
    @RequiresPermissions("user:add")
    public RestResult addUser(@RequestBody SysUser user){
        int su = sysUserService.addUser(user);
        return RestResult.success();
    }


    @GetMapping
    @RequiresRoles("user")
    @RequiresPermissions("user:get")
    public RestResult getUser(@RequestParam("userName") String userName){
        SysUserVO user = sysUserService.selectByUserName(userName);
        return RestResult.success(user);
    }

    /**
     * 新增用户角色
     * @param userRole 用户角色
     * @return
     */
    @PostMapping("/userRole")
    @RequiresPermissions("userRole:add")
    public RestResult addUser(@RequestBody SysUserRole userRole){
        int sur = sysUserRoleService.addUserRole(userRole);
        return RestResult.success();
    }




}
