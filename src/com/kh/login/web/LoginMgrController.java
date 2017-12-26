package com.kh.login.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.common.controller.BaseController;
import com.kh.common.ehcache.service.EhCacheService;
import com.kh.common.model.ResultModel;
import com.kh.common.shiro.model.ManagerToken;
import com.kh.common.utils.Constants;
import com.kh.login.service.LoginMgrService;
import com.kh.user.model.ManagerUserInfo;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

@Controller
public class LoginMgrController extends BaseController {

	@Resource
	private LoginMgrService loginMgrService;

	@Resource
	private EhCacheService ehCacheService;

	public LoginMgrService getLoginMgrService() {
		return loginMgrService;
	}

	public void setLoginMgrService(LoginMgrService loginMgrService) {
		this.loginMgrService = loginMgrService;
	}

	public EhCacheService getEhCacheService() {
		return ehCacheService;
	}

	public void setEhCacheService(EhCacheService ehCacheService) {
		this.ehCacheService = ehCacheService;
	}

	@RequestMapping(value = "/index")
	public String index() {
		Cache cache = ehCacheService.getCache("sampleCache3");
		System.out.println("-------------------------");
		List<String> keys = cache.getKeys();
		System.out.println(keys.size());
		cache.put(new Element("123", "456"));
		cache.flush();
		return "index";
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ResultModel login(ManagerUserInfo form) {
		Md5Hash md5 = new Md5Hash(form.getPassword(), Constants.SALT);
		ManagerToken token = new ManagerToken(form.getUsername(), md5.toString());
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
		} catch (DisabledAccountException e) {
			e.printStackTrace();
		} catch (AccountException e) {
			e.printStackTrace();
		}
		return successResult();
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public ResultModel test() {
		return successResult();
	}

}
