package com.kh.common.shiro.logincache.service;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import com.kh.common.shiro.logincache.impl.LoginCacheImpl;

public class LoginCacheMgrServiceImpl implements LoginCacheMgrService {
	
	private EhCacheManager shiroCacheManager;

	public EhCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(EhCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String cacheName) {
		return new LoginCacheImpl<>(cacheName, getShiroCacheManager());
	}

	@Override
	public void destroy() {
		
	}
	
}
