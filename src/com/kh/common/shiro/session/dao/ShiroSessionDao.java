package com.kh.common.shiro.session.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

public class ShiroSessionDao extends AbstractSessionDAO {

	@Override
	public void delete(Session sesion) {

	}

	@Override
	public Collection<Session> getActiveSessions() {
		return null;
	}

	@Override
	public void update(Session sesion) throws UnknownSessionException {

	}

	@Override
	protected Serializable doCreate(Session sesion) {
		return generateSessionId(sesion);
	}

	@Override
	protected Session doReadSession(Serializable sesionId) {
		return null;
	}

}
