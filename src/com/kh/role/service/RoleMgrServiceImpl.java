package com.kh.role.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.role.dao.RoleMgrDAO;

@Service(value="roleMgrService")
public class RoleMgrServiceImpl implements RoleMgrService {

    @Autowired
    private RoleMgrDAO roleMgrDAO;
    
    public RoleMgrDAO getRoleMgrDAO() {
        return roleMgrDAO;
    }

    public void setRoleMgrDAO(RoleMgrDAO roleMgrDAO) {
        this.roleMgrDAO = roleMgrDAO;
    }

    @Override
    public Set<String> queryRoleInfosByUserId(int userId) {
	Set<String> roles = new HashSet<String>();
	roles.add("1");
	roles.add("2");
	roles.add("3");
	roles.add("4");
	return roles;
    }

}
