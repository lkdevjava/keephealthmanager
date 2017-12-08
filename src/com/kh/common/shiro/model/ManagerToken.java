package com.kh.common.shiro.model;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ManagerToken extends UsernamePasswordToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String pwd;
	
	public ManagerToken(String userName, String pwd){
		super(userName, pwd);
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
