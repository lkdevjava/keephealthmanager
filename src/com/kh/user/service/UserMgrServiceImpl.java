package com.kh.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.user.dao.UserMgrDAO;

@Service(value = "userMgrService")
public class UserMgrServiceImpl implements UserMgrService {

	@Autowired
	private UserMgrDAO userMgrDao;

	public UserMgrDAO getUserMgrDao() {
		return userMgrDao;
	}

	public void setUserMgrDao(UserMgrDAO userMgrDao) {
		this.userMgrDao = userMgrDao;
	}
	
}
