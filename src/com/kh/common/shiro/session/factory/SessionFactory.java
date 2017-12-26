package com.kh.common.shiro.session.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.session.mgt.WebSessionContext;

public class SessionFactory implements org.apache.shiro.session.mgt.SessionFactory {

	@Override
	public Session createSession(SessionContext context) {
		SimpleSession session = new SimpleSession("manager_session");
		if (context != null && context instanceof WebSessionContext) {
			WebSessionContext webSession = (WebSessionContext) context;
			HttpServletRequest request = (HttpServletRequest) webSession.getServletRequest();
			String host = request.getLocalAddr() + ":" + request.getLocalPort();
			session.setHost(host);
		}
		return session;
	}

}
