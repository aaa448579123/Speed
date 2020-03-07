package org.phoenix.speed.shiro.dao;


import org.apache.ibatis.annotations.Mapper;
import org.phoenix.speed.shiro.pojo.po.SysUserRole;
@Mapper
public interface SysUserRoleMapper {
    /**
     * 根据id删除数据
     * @param userId 用户id
     * @return
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 新增数据
     * @param record SysUserRole对象
     * @return
     */
    int insert(SysUserRole record);

    /**
     * 新增数据
     * @param record SysUserRole对象
     * @return
     */
    int insertSelective(SysUserRole record);

    /**
     * 根据id查询数据
     * @param userId 用户id
     * @return
     */
    SysUserRole selectByPrimaryKey(String userId);
    /**
     * 更新数据
     * @param record SysUserRole对象
     * @return
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     * 更新数据
     * @param record SysUserRole对象
     * @return
     */
    int updateByPrimaryKey(SysUserRole record);
}