package org.phoenix.speed.domain.service.impl;

import org.phoenix.speed.domain.dao.SysUserMapper;
import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.pojo.vo.SysUserVO;
import org.phoenix.speed.domain.service.SysUserService;
import org.phoenix.speed.util.CommonUtil;
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
        sysUser.setUserId(CommonUtil.createId());
        sysUser.setCreateTime(new Date());
        return sysUserMapper.insertSelective(sysUser);
    }

}
