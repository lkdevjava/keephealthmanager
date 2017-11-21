package com.kh.login.web;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.common.shiro.model.ShiroToken;
import com.kh.login.service.LoginMgrService;

@Controller
public class LoginMgrController extends BaseController {

    @Resource
    private LoginMgrService loginMgrService;

    public LoginMgrService getLoginMgrService() {
	return loginMgrService;
    }

    public void setLoginMgrService(LoginMgrService loginMgrService) {
	this.loginMgrService = loginMgrService;
    }

    @RequestMapping(value = "/index")
    public String index() {
	ShiroToken token = new ShiroToken("123", "123");
	token.setRememberMe(true);
	SecurityUtils.getSubject().login(token);
	return "index";
    }

}
