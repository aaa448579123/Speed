package org.phoenix.speed.domain.pojo.vo;

import org.phoenix.speed.domain.pojo.po.SysMenu;

import java.util.Date;
import java.util.List;

public class SysRoleVO {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 描述
     */
    private String describe;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 角色权限
     */
    private List<SysMenu> sysMenuList;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<SysMenu> getSysMenuList() {
        return sysMenuList;
    }

    public void setSysMenuList(List<SysMenu> sysMenuList) {
        this.sysMenuList = sysMenuList;
    }
}