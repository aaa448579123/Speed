package org.phoenix.speed.domain.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.phoenix.speed.domain.pojo.po.SysMenu;
import org.phoenix.speed.domain.pojo.po.SysRole;
import org.phoenix.speed.domain.pojo.po.SysUser;
import org.phoenix.speed.domain.pojo.vo.SysUserVO;
import org.phoenix.speed.domain.service.SysMenuService;
import org.phoenix.speed.domain.service.SysRoleService;
import org.phoenix.speed.domain.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userName = user.getUserName();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<SysRole> roleList = this.roleService.selectUserRole(userName);
        Set<String> roleSet = roleList.stream().map(SysRole::getRoleName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<SysMenu> permissionList = this.menuService.selectUserPermission(userName);
        Set<String> permissionSet = permissionList.stream().map(SysMenu::getPermission).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
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
