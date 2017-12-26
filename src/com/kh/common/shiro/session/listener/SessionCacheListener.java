package com.kh.common.shiro.session.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.kh.common.shiro.session.service.ShiroSessionService;

public class SessionCacheListener implements SessionListener {

	private ShiroSessionService sessionService;

	public ShiroSessionService getSessionService() {
		return sessionService;
	}

	public void setSessionService(ShiroSessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	public void onExpiration(Session session) {
//		sessionService.deleteSession(session);
	}

	@Override
	public void onStart(Session session) {

	}

	@Override
	public void onStop(Session session) {

	}

}
