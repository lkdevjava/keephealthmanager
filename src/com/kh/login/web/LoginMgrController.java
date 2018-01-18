package com.kh.login.web;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.common.shiro.model.ManagerToken;
import com.kh.common.utils.Constants;
import com.kh.login.service.LoginMgrService;
import com.kh.user.model.ManagerUserInfo;

@Controller
public class LoginMgrController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(LoginMgrController.class);

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

	@RequestMapping(value = "/login")
	public String login(ManagerUserInfo form) {
		Md5Hash md5 = new Md5Hash(form.getPassword(), Constants.SALT);
		ManagerToken token = new ManagerToken(form.getUsername(), md5.toString());
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
		} catch (DisabledAccountException e) {
			logger.info(form.getUsername() + "登陆失败,失败原因: 用户被禁用");
			getRequest().setAttribute("message", "用户被禁用");
			return "index";
		} catch (AccountException e) {
			logger.info(form.getUsername() + "登陆失败,失败原因: 用户名或密码错误");
			getRequest().setAttribute("message", "用户名或密码错误");
			return "index";
		}
		return "main";
	}

}
