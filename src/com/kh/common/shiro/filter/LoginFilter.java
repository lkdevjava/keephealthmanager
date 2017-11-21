package com.kh.common.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import com.kh.common.shiro.model.ShiroToken;
import com.kh.common.utils.CommonUtils;
import com.kh.common.utils.LoggerUtil;

public class LoginFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp,
	    Object obj) throws Exception {
	ShiroToken token = (ShiroToken) SecurityUtils.getSubject()
		.getPrincipal();
	if (null != token && isLoginRequest(req, resp)) {
	    LoggerUtil.info(LoginFilter.class, "通过用户登陆拦截器验证");
	    return true;
	}
	if (CommonUtils.isAjax(req)) {
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("code", "00001");
	    map.put("msg", "用户未登陆或登陆过期请重新登陆");
	    LoggerUtil.info(LoginFilter.class, CommonUtils.toJsonString(map));
	    CommonUtils.out(resp, map);
	}
	return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest req, ServletResponse resp)
	    throws Exception {
	LoggerUtil.info(LoginFilter.class, "用户未登陆或登陆过期请重新登陆");
	// 如果返回JSON信息的话,就不需要跳转
	if (!CommonUtils.isAjax(req)) {
	    saveRequestAndRedirectToLogin(req, resp);
	}
	return false;
    }

}
