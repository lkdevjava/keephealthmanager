package com.kh.common.shiro.session.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.InitializingBean;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class ShiroSessionServiceImpl implements ShiroSessionService, InitializingBean {

	private Log logger = LogFactory.getLog(ShiroSessionServiceImpl.class);

	private String cacheName;

	private EhCacheManager shiroCacheManager;

	private Cache cache;

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public EhCacheManager getShiroCacheManager() {
		return shiroCacheManager;
	}

	public void setShiroCacheManager(EhCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		cache = shiroCacheManager.getCacheManager().getCache(cacheName);
	}

	@Override
	public void saveSession(Session session) {
		Element element = cache.get(session.getId());
		if (null == element) {
			element = new Element(session.getId(), session);
			getCache().put(element);
			getCache().flush();
		} else {
			logger.debug("当前session已存在,不再保存");
		}
	}

	@Override
	public void updateSession(Session session) {
		Element element = cache.get(session.getId());
		if (null == element) {
			element = new Element(session.getId(), session);
			getCache().put(element);
		} else {
			getCache().remove(session.getId());
			element = new Element(session.getId(), session);
			getCache().put(element);
		}
		getCache().flush();
	}

	@Override
	public void deleteSession(Session session) {
		getCache().remove(session.getId());
		getCache().flush();
	}

	@Override
	public Session getSession(Serializable sessionId) {
		Element element = getCache().get(sessionId);
		Session session = (Session) element.getObjectValue();
		getCache().flush();
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Session> getAllSession() {
		List<Session> sessions = new ArrayList<>();
		List<Serializable> keys = getCache().getKeys();
		if (keys != null && keys.size() > 0) {
			for (Serializable key : keys) {
				Element el = getCache().get(key);
				sessions.add((Session) el.getObjectValue());
			}
		}
		getCache().flush();
		return sessions;
	}

}
