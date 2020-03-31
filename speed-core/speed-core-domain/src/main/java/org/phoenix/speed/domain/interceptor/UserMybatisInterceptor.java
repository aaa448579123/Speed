package org.phoenix.speed.domain.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
@Order
@Intercepts({@Signature(type = Executor.class, method = "update",
        args = {MappedStatement.class, Object.class})})
public class UserMybatisInterceptor extends HandlerInterceptorAdapter implements Interceptor {

    @Autowired
    private SysUserService sysUserService;
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs(); //方法参数
        if (args[1] instanceof BaseUser && !args[1].getClass().equals(BaseUser.class)){
            SysUser sysUser = new SysUser();
            BeanUtils.copyProperties(args[1],sysUser);
            String userId = sysUserService.addUser(sysUser);
            BaseUser baseUser = (BaseUser)args[1];
            baseUser.setUserId(userId);
        }
        return invocation.proceed();
    }

}
