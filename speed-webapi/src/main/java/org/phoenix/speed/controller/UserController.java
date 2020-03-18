package org.phoenix.speed.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.phoenix.speed.exception.RestApi;
import org.phoenix.speed.exception.RestResult;
import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.pojo.po.SysUserRole;
import org.phoenix.speed.domain.pojo.vo.SysUserVO;
import org.phoenix.speed.domain.service.SysUserRoleService;
import org.phoenix.speed.domain.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void login(){
        String userName = "admin";
        String password = "123456";
        // 通过用户名到数据库查询用户信息
        //SysUserVO userVO = sysUserService.selectByUserName(userName);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        SecurityUtils.getSubject().login(token);
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
    //@RequiresPermissions("")
    public RestResult getUser(@RequestParam("userName") String userName){
        SysUserVO user = sysUserService.selectByUserName(userName);
        return RestResult.success(user);
    }

    @GetMapping("/a")
    @RequiresRoles("user")
    public RestResult getUser1(@RequestParam("userName") String userName){
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
