package com.kh.common.ehcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

@Service(value="ehCacheService")
public class EhCacheServiceImpl implements EhCacheService {

	@Autowired
	private EhCacheCacheManager ehCacheManager;

	public EhCacheCacheManager getEhCacheManager() {
		return ehCacheManager;
	}

	public void setEhCacheManager(EhCacheCacheManager ehCacheManager) {
		this.ehCacheManager = ehCacheManager;
	}

	@Override
	public Cache getCache(String cacheName) {
		CacheManager manager = ehCacheManager.getCacheManager();
		return manager.getCache(cacheName);
	}
	
	
	
}
