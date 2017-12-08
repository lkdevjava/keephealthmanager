package com.kh.role.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.role.service.RoleMgrService;
import com.kh.user.model.ManagerUserInfo;

@Controller
@RequestMapping(value = "/role")
public class RoleMgrController extends BaseController {

	@Resource
	private RoleMgrService roleMgrService;

	public RoleMgrService getRoleMgrService() {
		return roleMgrService;
	}

	public void setRoleMgrService(RoleMgrService roleMgrService) {
		this.roleMgrService = roleMgrService;
	}

	@RequestMapping(value = "queryRoleRelPer")
	public String queryRoleRelPer(ManagerUserInfo vo) {
		return "role/role";
	}

}
