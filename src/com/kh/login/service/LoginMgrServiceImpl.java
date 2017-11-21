package com.kh.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.login.dao.LoginMgrDAO;

@Service(value = "loginMgrService")
public class LoginMgrServiceImpl implements LoginMgrService {

	@Autowired
	private LoginMgrDAO loginMgrDAO;

	public LoginMgrDAO getLoginMgrDAO() {
		return loginMgrDAO;
	}

	public void setLoginMgrDAO(LoginMgrDAO loginMgrDAO) {
		this.loginMgrDAO = loginMgrDAO;
	}

	/**
	 * 实现: 用户登录查询
	 * @param username 用户名
	 * @param passwd 密码
	 * @return 
	 */
	@Override
	public boolean queryUserInfoByUserNameAndPasswd(String username,
		String passwd) {
	    return loginMgrDAO.queryUserInfoByUserNameAndPasswd(username, passwd);
	}

}
