package org.phoenix.speed.shiro.dao;


import org.apache.ibatis.annotations.Mapper;
import org.phoenix.speed.shiro.pojo.po.SysRoleMenu;
@Mapper
public interface SysRoleMenuMapper {
    /**
     * 根据id删除数据
     * @param roleId 角色id
     * @return
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * 新增数据
     * @param record SysRoleMenu对象
     * @return
     */
    int insert(SysRoleMenu record);

    /**
     *新增数据
     * @param record SysRoleMenu对象
     * @return
     */
    int insertSelective(SysRoleMenu record);

    /**
     * 根据id查询数据
     * @param roleId 角色id
     * @return
     */
    SysRoleMenu selectByPrimaryKey(String roleId);

    /**
     * 更新数据
     * @param record SysRoleMenu对象
     * @return
     */
    int updateByPrimaryKeySelective(SysRoleMenu record);

    /**
     * 更新数据
     * @param record SysRoleMenu对象
     * @return
     */
    int updateByPrimaryKey(SysRoleMenu record);
}