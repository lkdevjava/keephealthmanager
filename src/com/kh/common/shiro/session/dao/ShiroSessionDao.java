package com.kh.common.shiro.session.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import com.kh.common.shiro.session.service.ShiroSessionService;

public class ShiroSessionDao extends AbstractSessionDAO {

	private ShiroSessionService sessionService;

	public ShiroSessionService getSessionService() {
		return sessionService;
	}

	public void setSessionService(ShiroSessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	public void delete(Session sesion) {
		sessionService.deleteSession(sesion);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		return sessionService.getAllSession();
	}

	@Override
	public void update(Session sesion) throws UnknownSessionException {
		sessionService.updateSession(sesion);
	}

	@Override
	protected Serializable doCreate(Session sesion) {
		Serializable sessionId = generateSessionId(sesion);
		assignSessionId(sesion, sessionId);
		sessionService.saveSession(sesion);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sesionId) {
		return sessionService.getSession(sesionId);
	}
	
}
