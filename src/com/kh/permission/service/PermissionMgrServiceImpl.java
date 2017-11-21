package com.kh.permission.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.permission.dao.PermissionMgrDAO;

@Service(value = "permissionMgrService")
public class PermissionMgrServiceImpl implements PermissionMgrService {

    @Autowired
    private PermissionMgrDAO permissionMgrDAO;

    public PermissionMgrDAO getPermissionMgrDAO() {
	return permissionMgrDAO;
    }

    public void setPermissionMgrDAO(PermissionMgrDAO permissionMgrDAO) {
	this.permissionMgrDAO = permissionMgrDAO;
    }

    @Override
    public Set<String> queryRoleRelPermissionsInfosByRoles(Set<String> roles) {
	Set<String> pers = new HashSet<String>();
	pers.add("123[52213]");
	pers.add("34563[52213]");
	pers.add("/role/queryRoleRelPer[52213]");
	return pers;
    }

}
