package org.phoenix.speed.shiro.service.impl;

import org.phoenix.speed.shiro.dao.SysUserMapper;
import org.phoenix.speed.shiro.pojo.po.SysUser;
import org.phoenix.speed.shiro.pojo.vo.SysUserVO;
import org.phoenix.speed.shiro.service.SysUserService;
import org.phoenix.speed.shiro.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserVO selectByUserName(String userName) {
        return sysUserMapper.selectByUserName(userName);
    }

    @Override
    public int addUser(SysUser sysUser) {
        sysUser.setUserId(CommonUtil.uuid());
        sysUser.setCreateTime(new Date());
        return sysUserMapper.insertSelective(sysUser);
    }

}
