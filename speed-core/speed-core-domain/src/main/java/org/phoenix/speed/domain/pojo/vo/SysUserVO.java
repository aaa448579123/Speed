package org.phoenix.speed.domain.pojo.vo;

import org.phoenix.speed.domain.pojo.po.SysUser;

import java.util.Date;

public class SysUserVO extends SysUser{

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名
     */
    private String roleName;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysUserVO{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}