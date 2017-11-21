package com.kh.login.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "loginMgrDAO")
public interface LoginMgrDAO {

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
