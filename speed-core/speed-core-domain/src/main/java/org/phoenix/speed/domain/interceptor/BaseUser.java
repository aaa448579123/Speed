package org.phoenix.speed.domain.interceptor;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class BaseUser {
    /**
     * 用户id
     */
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String userId;

    /**
     * 用户名
     */
    @TableField(exist = false)
    private String userName;

    /**
     * 密码
     */
    @TableField(exist = false)
    private String password;

    /**
     * 创建时间
     */
    @TableField(exist = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(exist = false)
    private Date updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
