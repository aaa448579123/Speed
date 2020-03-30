package org.phoenix.speed.domain.service.impl;

import org.phoenix.speed.domain.dao.SysRoleMapper;
import org.phoenix.speed.domain.pojo.po.SysRole;
import org.phoenix.speed.domain.service.SysRoleService;
import org.phoenix.speed.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;



    /**
     * 根据username查找用户角色
     * @param userName 用户名
     * @return
     */
    @Override
    public List<SysRole> selectUserRole(String userName) {
        return sysRoleMapper.selectUserRole(userName);
    }

    /**
     * 新增角色数据
     * @param sysRole 角色对象
     * @return
     */
    @Override
    public int addRole(SysRole sysRole) {
        sysRole.setRoleId(CommonUtil.createId());
        sysRole.setCreateTime(new Date());
        return sysRoleMapper.insertSelective(sysRole);
    }


}
