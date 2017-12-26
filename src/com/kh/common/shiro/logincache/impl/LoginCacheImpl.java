package com.kh.common.shiro.logincache.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import net.sf.ehcache.Element;

public class LoginCacheImpl<K, V> implements Cache<K, V> {

	private EhCacheManager shiroCacheManager;

	private net.sf.ehcache.Cache cache;

	private String cacheName;

	public EhCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(EhCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

	public net.sf.ehcache.Cache getCache() {
		if (null == cache) {
			cache = shiroCacheManager.getCacheManager().getCache(cacheName);
		}
		return cache;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public LoginCacheImpl() {
	}

	public LoginCacheImpl(String cacheName, EhCacheManager shiroCacheManager) {
		this.cacheName = cacheName;
		this.shiroCacheManager = shiroCacheManager;
	}

	@Override
	public void clear() throws CacheException {
		getCache().removeAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) throws CacheException {
		Element el = getCache().get(key);
		if (el != null) {
			return (V) el.getObjectValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<K> keys() {
		Set<K> keys = new HashSet<>();
		keys.addAll(getCache().getKeys());
		return keys;
	}

	@Override
	public V put(K key, V val) throws CacheException {
		getCache().put(new Element(key, val));
		return val;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(K key) throws CacheException {
		Element el = getCache().get(key);
		if (null != el) {
			return (V) el.getObjectValue();
		}
		return null;
	}

	@Override
	public int size() {
		return getCache().getSize();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<V> values() {
		List<V> vals = new ArrayList<>();
		List<K> keys = getCache().getKeys();
		if (keys != null && keys.size() > 0) {
			for (K key : keys) {
				vals.add((V) getCache().get(key).getObjectValue());
			}
		}
		return vals;
	}

}
