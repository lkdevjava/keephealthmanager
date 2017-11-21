package com.kh.common.shiro.filter;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.BeanInitializationException;

public class KeepHealthShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    @Override
    protected AbstractShiroFilter createInstance() throws Exception {
	org.apache.shiro.mgt.SecurityManager securityManager = getSecurityManager();
	if (securityManager == null) {
	    String msg = "SecurityManager property must be set.";
	    throw new BeanInitializationException(msg);
	}
	if (!(securityManager instanceof WebSecurityManager)) {
	    String msg = "The security manager does not implement the WebSecurityManager interface.";
	    throw new BeanInitializationException(msg);
	}
	FilterChainManager manager = createFilterChainManager();
	PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
	chainResolver.setFilterChainManager(manager);

	return new KeepHealthShiroFilter((WebSecurityManager) securityManager,
		chainResolver);
    }

    @Override
    public Class getObjectType() {
	return KeepHealthShiroFilter.class;
    }

}
