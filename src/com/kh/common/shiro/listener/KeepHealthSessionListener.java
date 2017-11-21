package com.kh.common.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.kh.common.utils.LoggerUtil;

public class KeepHealthSessionListener implements SessionListener {

	@Override
	public void onExpiration(Session session) {
		LoggerUtil.debug(KeepHealthSessionListener.class,
				"会话过期: " + session.getId());
	}

	@Override
	public void onStart(Session session) {
		LoggerUtil.debug(KeepHealthSessionListener.class,
				"会话创建: " + session.getId());
	}

	@Override
	public void onStop(Session session) {
		LoggerUtil.debug(KeepHealthSessionListener.class,
				"会话停止: " + session.getId());
	}

}
