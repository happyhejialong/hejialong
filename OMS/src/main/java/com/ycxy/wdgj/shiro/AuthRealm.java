package com.ycxy.wdgj.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ycxy.wdgj.common.utils.ObjectUtils;
import com.ycxy.wdgj.model.User;
import com.ycxy.wdgj.service.RoleService;
import com.ycxy.wdgj.service.UserService;
import com.ycxy.wdgj.taobao.domain.Role;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    // 认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.findUserByUsername(username);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();// 获取session中的用户
        List<Role> roleList = roleService.list(user.getId());
        List<String> permissionList = new ArrayList<String>();

        if (!ObjectUtils.isEmpty(roleList)) {
            for (Role role : roleList) {
                permissionList.add(role.getSubRoleName());
            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);// 将权限放入shiro中.
        return info;

    }

}