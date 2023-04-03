package com.sample.lwj.web.shiro;

import com.sample.lwj.remote.dto.UserDTO;
import com.sample.lwj.remote.enums.UserStatusEnum;
import com.sample.lwj.remote.service.IMenuServiceRemote;
import com.sample.lwj.remote.service.IUserServiceRemote;
import com.sample.lwj.web.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 认证
 * @date 2021/8/4 15:46
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserServiceRemote userServiceRemote;

    @Autowired
    private IMenuServiceRemote menuServiceRemote;



    /**
     * 认证(登录时调用)
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserDTO userDTO = userServiceRemote.selectByUserAccount(token.getUsername());
        //账号不存在
        if (userDTO == null) {
            throw new UnknownAccountException("shiro.unknown.account");
        }
//        if (UserStatusEnum.DISABLE.getCode().equals(userDTO.getStatus())) {
//            throw new LockedAccountException("shiro.locked.account");
//        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDTO, userDTO.getPassword(), getName());
        return info;
    }

    /**
     * 授权(验证权限时调用)
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserDTO userDTO = (UserDTO) principalCollection.getPrimaryPrincipal();
        //获取用户权限
        Set<String> permissions = new HashSet<>();
        //用户权限列表
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (userDTO.isSuperAdminRole()) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
            permissions = menuServiceRemote.selectPermissionsByRoleId(userDTO.getRoleId());
            info.setStringPermissions(permissions);
        }
        return info;
    }


    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.HASH_ALGORITHM_NAME);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.HASH_ITERATIONS);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
