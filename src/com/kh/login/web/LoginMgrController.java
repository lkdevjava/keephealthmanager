package com.kh.login.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
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
	return "index";
    }

}
