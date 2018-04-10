package com.ycxy.wdgj.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.util.DigestUtils;

public class CredentialsMatcher extends SimpleCredentialsMatcher{

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
       UsernamePasswordToken userToken=(UsernamePasswordToken) token;
       String password=DigestUtils.md5DigestAsHex(new String(userToken.getPassword()).getBytes());
       String realmPassword=(String) info.getCredentials();
       return password.equals(realmPassword);
    }
    
}
