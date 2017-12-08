package com.kh.login.service;

import com.kh.user.model.ManagerUserInfo;

public interface LoginMgrService {

    /**
     * 实现: 用户登录查询
     * 
     * @param username
     *            用户名
     * @param passwd
     *            密码
     * @return
     */
    public ManagerUserInfo queryUserInfoByUserNameAndPasswd(String username,
	    String passwd);

}
