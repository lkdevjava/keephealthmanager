package com.kh.common.shiro.model;

import java.io.Serializable;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ShiroToken extends UsernamePasswordToken implements
	Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;
    
    private String username;

    private String passwd;
    
    private String alt;

    public ShiroToken(String username, String passwd) {
	super(username, passwd);
	this.username = username;
	this.passwd = passwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPasswd() {
	return passwd;
    }

    public void setPasswd(String passwd) {
	this.passwd = passwd;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

}
