package org.phoenix.speed.domain.dao;


import org.phoenix.speed.domain.pojo.po.SysRole;

import java.util.List;

public interface SysRoleMapper {
    /**
     * 根据id删除数据
     * @param roleId 角色id
     * @return
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * 新增数据
     * @param record SysRole对象
     * @return
     */
    int insert(SysRole record);

    /**
     * 新增数据
     * @param record SysRole对象
     * @return
     */
    int insertSelective(SysRole record);

    /**
     * 根据id查询数据
     * @param roleId 角色id
     * @return
     */
    SysRole selectByPrimaryKey(String roleId);


    /**
     * 更新数据
     * @param record  SysRole对象
     * @return
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 更新数据
     * @param record SysRole对象
     * @return
     */
    int updateByPrimaryKey(SysRole record);

    /**
     * 根据username查找用户角色
     * @param userName 用户名
     * @return
     */
    List<SysRole> selectUserRole(String userName);

}