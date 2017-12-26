package com.kh.common.shiro.session.service;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;

public interface ShiroSessionService {

	public void saveSession(Session session);
	
	public void updateSession(Session session);
	
	public void deleteSession(Session session);
	
	public Session getSession(Serializable sessionId);
	
	public Collection<Session> getAllSession();
	
}
