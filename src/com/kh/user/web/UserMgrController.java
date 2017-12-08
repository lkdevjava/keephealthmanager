package com.kh.user.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.user.service.UserMgrService;

@Controller
@RequestMapping(value="/user")
public class UserMgrController extends BaseController {

	@Resource
	private UserMgrService userMgrService;

	public UserMgrService getUserMgrService() {
		return userMgrService;
	}

	public void setUserMgrService(UserMgrService userMgrService) {
		this.userMgrService = userMgrService;
	}
	
}
