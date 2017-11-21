package com.kh.permission.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.common.controller.BaseController;
import com.kh.permission.service.PermissionMgrService;

@Controller
@RequestMapping(value = "/permission")
public class PermissionMgrController extends BaseController {

    @Resource
    private PermissionMgrService permissionMgrService;

    public PermissionMgrService getPermissionMgrService() {
	return permissionMgrService;
    }

    public void setPermissionMgrService(
	    PermissionMgrService permissionMgrService) {
	this.permissionMgrService = permissionMgrService;
    }

}
