package com.kh.common.shiro.filter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;

public class KeepHealthShiroFilter extends ShiroFilter {

    public KeepHealthShiroFilter(WebSecurityManager webSecurityManager,
	    FilterChainResolver resolver) {
	super();
	if (webSecurityManager == null) {
	    throw new IllegalArgumentException(
		    "WebSecurityManager property cannot be null.");
	}
	setSecurityManager(webSecurityManager);
	if (resolver != null) {
	    setFilterChainResolver(resolver);
	}
    }

    @Override
    protected ServletResponse wrapServletResponse(HttpServletResponse orig,
	    ShiroHttpServletRequest request) {
	return new KeepHealthServletResponse(orig, getServletContext(), request);
    }

}
