package com.kh.common.utils;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class CommonUtils {

    /**
     * 实现: 判断用户请求方式
     * 
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request) {
	return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request)
		.getHeader("X-Requested-With"));
    }

    /**
     * 实现: 输入JSON格式的信息
     * 
     * @param response
     * @param resultMap
     */
    public static void out(ServletResponse response,
	    Map<String, String> resultMap) {
	PrintWriter out = null;
	try {
	    response.setCharacterEncoding("UTF-8");
	    out = response.getWriter();
	    out.println(JSONObject.parse(JSONObject.toJSONString(resultMap))
		    .toString());
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (null != out) {
		out.flush();
		out.close();
	    }
	}
    }

    /**
     * 实现: 将对象转为JSONstring
     * 
     * @param obj
     *            转换对象
     * @return 结果
     */
    public static String toJsonString(Object obj) {
	return JSONObject.toJSONString(obj);
    }

}
