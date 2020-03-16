package org.phoenix.speed.shiro.dao;


import org.apache.ibatis.annotations.Mapper;
import org.phoenix.speed.shiro.pojo.po.SysMenu;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    /**
     * 根据id删除数据
     * @param menuId 菜单id
     * @return
     */
    int deleteByPrimaryKey(String menuId);

    /**
     * 新增数据
     * @param record SysMenu对象
     * @return
     */
    int insert(SysMenu record);

    /**
     * 新增数据
     * @param record SysMenu对象
     * @return
     */
    int insertSelective(SysMenu record);

    /**
     * 根据id查询数据
     * @param menuId 菜单id
     * @return
     */
    SysMenu selectByPrimaryKey(String menuId);

    /**
     * 更新数据
     * @param record SysMenu对象
     * @return
     */
    int updateByPrimaryKeySelective(SysMenu record);

    /**
     * 更新数据
     * @param record SysMenu对象
     * @return
     */
    int updateByPrimaryKey(SysMenu record);

    /**
     * 根据用户名查找用户权限集
     * @param userName 用户名
     * @return
     */
    List<SysMenu> selectUserPermission(String userName);

}