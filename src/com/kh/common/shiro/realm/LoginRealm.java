package com.kh.common.shiro.realm;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.common.shiro.model.ManagerToken;
import com.kh.login.service.LoginMgrService;
import com.kh.permission.service.PermissionMgrService;
import com.kh.role.service.RoleMgrService;
import com.kh.user.model.ManagerUserInfo;

public class LoginRealm extends AuthorizingRealm {

	@Autowired
	private LoginMgrService loginMgrService;

	@Autowired
	private RoleMgrService roleMgrService;

	@Autowired
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

	public void setPermissionMgrService(PermissionMgrService permissionMgrService) {
		this.permissionMgrService = permissionMgrService;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		ManagerToken managerToken = (ManagerToken) token;
		ManagerUserInfo userinfo = loginMgrService.queryUserInfoByUserNameAndPasswd(managerToken.getUsername(),
				managerToken.getPwd());
		if (null == userinfo) {
			throw new AccountException("用户名或密码错误");
		}
		if (0 == userinfo.getStatus()) {
			throw new DisabledAccountException("用户禁止登陆");
		}
		return new SimpleAuthenticationInfo(userinfo, userinfo.getPassword(), getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("---------------------------------------");
		String username = (String) principals.getPrimaryPrincipal();  
//		ManagerUserInfo info = (ManagerUserInfo) SecurityUtils.getSubject().getPrincipal();
//		System.out.println(info.getId());
//		Set<String> roles = roleMgrService.queryRoleInfosByUserId(info.getId());
//		Set<String> permissions = permissionMgrService.queryRoleRelPermissionsInfosByRoles(roles);
//		System.out.println(permissions.size());
//		for(String str : permissions){
//			System.out.println(str);
//		}
//		SimpleAuthorizationInfo author = new SimpleAuthorizationInfo(roles);
//		author.setStringPermissions(permissions);
		return null;
	}

	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection collection) {
		super.clearCachedAuthenticationInfo(new SimplePrincipalCollection(collection, getName()));
	}

	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection collection) {
		super.clearCachedAuthorizationInfo(new SimplePrincipalCollection(collection, getName()));
	}

}
