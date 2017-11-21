package com.kh.common.shiro.dao;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

public class KeepHealthSessionDAO extends AbstractSessionDAO {

    @Override
    public void delete(Session arg0) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public Collection<Session> getActiveSessions() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void update(Session arg0) throws UnknownSessionException {
	// TODO Auto-generated method stub
	
    }

    @Override
    protected Serializable doCreate(Session arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    protected Session doReadSession(Serializable arg0) {
	// TODO Auto-generated method stub
	return null;
    }

}
