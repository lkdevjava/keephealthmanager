package com.kh.common.shiro.logincache.mgr;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import com.kh.common.shiro.logincache.service.LoginCacheMgrService;

public class LoginCacheManager implements CacheManager, Destroyable {
	
	private LoginCacheMgrService loginCacheMgrService;
	
	public LoginCacheMgrService getLoginCacheMgrService() {
		return loginCacheMgrService;
	}

	public void setLoginCacheMgrService(LoginCacheMgrService loginCacheMgrService) {
		this.loginCacheMgrService = loginCacheMgrService;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return loginCacheMgrService.getCache(name);
	}

	@Override
	public void destroy() throws Exception {
		
	}

}
