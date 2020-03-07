package org.phoenix.speed.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.phoenix.speed.shiro.pojo.vo.SysUserVO;
import org.phoenix.speed.shiro.service.SysMenuService;
import org.phoenix.speed.shiro.service.SysRoleService;
import org.phoenix.speed.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 自定义Realm
 */
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysMenuService menuService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 通过用户名到数据库查询用户信息
        SysUserVO userVO = this.userService.selectByUserName(userName);

        if (userVO == null)
            throw new UnknownAccountException("账号未注册！");
        if (!password.equals(userVO.getPassword()))
            throw new IncorrectCredentialsException("用户名或密码错误！");
        return new SimpleAuthenticationInfo(userVO, password, getName());
    }
}
