package com.kh.common.shiro.logincache.service;

import org.apache.shiro.cache.Cache;

public interface LoginCacheMgrService {

	public <K, V>Cache<K, V> getCache(String cacheName);
	
	public void destroy();
	
}
