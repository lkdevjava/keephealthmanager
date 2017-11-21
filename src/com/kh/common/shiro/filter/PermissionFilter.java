package com.kh.common.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

public class PermissionFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest arg0,
	    ServletResponse arg1, Object arg2) throws Exception {
	String[] urlmap = (String[]) arg2;
	Subject sub = getSubject(arg0, arg1);
	System.out.println(sub.isPermitted("/role/queryRoleRelPer"));
	return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest arg0, ServletResponse arg1)
	    throws Exception {
	saveRequest(arg0);
	return false;
    }

}
