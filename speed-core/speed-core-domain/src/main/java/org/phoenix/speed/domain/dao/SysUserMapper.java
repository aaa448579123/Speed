package org.phoenix.speed.domain.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.pojo.vo.SysUserVO;

public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据id查询数据
     * @param userId 有用户id
     * @return
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 新增数据
     * @param record SysUser对象
     * @return
     */
    int insert(SysUser record);

    /**
     * 新增数据
     * @param record SysUser对象
     * @return
     */
    int insertSelective(SysUser record);

    /**
     * 根据id查询数据
     * @param userId 用户id
     * @return
     */
    SysUser selectByPrimaryKey(String userId);

    /**
     * 根据用户名查询数据
     * @param userName 用户名
     * @return
     */
    SysUserVO selectByUserName(String userName);

    /**
     * 更新数据
     * @param record SysUser对象
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 更新数据
     * @param record SysUser对象
     * @return
     */
    int updateByPrimaryKey(SysUser record);


}