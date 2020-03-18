package org.phoenix.speed.domain.pojo.po;

/**
 * @mbg.generated Thu Mar 05 21:13:37 CST 2020
 */
public class SysUserRole {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

}