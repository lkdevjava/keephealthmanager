package com.kh.common.shiro.realm;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.kh.common.shiro.model.ShiroToken;
import com.kh.login.service.LoginMgrService;
import com.kh.permission.service.PermissionMgrService;
import com.kh.role.service.RoleMgrService;

public class LoginRealm extends AuthorizingRealm {

    public LoginRealm() {
	super();
    }

    @Resource
    private LoginMgrService loginMgrService;

    @Resource
    private RoleMgrService roleMgrService;

    @Resource
    private PermissionMgrService permissionMgrService;

    public LoginMgrService getLoginMgrService() {
	return loginMgrService;
    }

    public void setLoginMgrService(LoginMgrService loginMgrService) {
	this.loginMgrService = loginMgrService;
    }

    public RoleMgrService getRoleMgrService() {
	return roleMgrService;
    }

    public void setRoleMgrService(RoleMgrService roleMgrService) {
	this.roleMgrService = roleMgrService;
    }

    public PermissionMgrService getPermissionMgrService() {
	return permissionMgrService;
    }

    public void setPermissionMgrService(
	    PermissionMgrService permissionMgrService) {
	this.permissionMgrService = permissionMgrService;
    }

    // 权限加载
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
	ShiroToken token = (ShiroToken) arg0.getPrimaryPrincipal();
	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	Set<String> roles = roleMgrService.queryRoleInfosByUserId(token
		.getUserId());
	info.setRoles(roles);
	Set<String> pers = permissionMgrService
		.queryRoleRelPermissionsInfosByRoles(roles);
	info.setStringPermissions(pers);
	return info;
    }

    // 用户登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
	    AuthenticationToken arg0) throws AuthenticationException {
	ShiroToken token = (ShiroToken) arg0;
	if (StringUtils.isEmpty(token.getPasswd())) {
	    token.setPasswd("");
	}
	boolean flag = loginMgrService.queryUserInfoByUserNameAndPasswd(
		token.getUsername(), token.getPasswd());
	if (!flag) {
	    throw new AccountException("登录失败");
	}
	return new SimpleAuthenticationInfo(token, token.getPasswd(), getName());
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
	super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
	super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
	super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
	getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
	getAuthenticationCache().clear();
    }

    public void clearAllCache() {
	clearAllCachedAuthenticationInfo();
	clearAllCachedAuthorizationInfo();
    }

}
