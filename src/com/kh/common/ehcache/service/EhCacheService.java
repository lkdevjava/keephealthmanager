package com.kh.common.ehcache.service;

import net.sf.ehcache.Cache;

public interface EhCacheService {

	public Cache getCache(String cacheName);
	
}
