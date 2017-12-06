package com.kh.login.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.common.ehcache.service.EhCacheService;
import com.kh.login.service.LoginMgrService;

import net.sf.ehcache.Cache;

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
		for(String key : keys){
			System.out.println(key);
		}
		System.out.println((String)cache.get("keephealth").getObjectValue());
		cache.flush();
		return "index";
	}

}
