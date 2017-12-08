package com.kh.login.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kh.user.model.ManagerUserInfo;

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
	public ManagerUserInfo queryUserInfoByUserNameAndPasswd(@Param("username") String username,
			@Param("passwd") String passwd);

}
