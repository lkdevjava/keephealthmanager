package com.kh.login.service;

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
    public boolean queryUserInfoByUserNameAndPasswd(String username,
	    String passwd);

}
