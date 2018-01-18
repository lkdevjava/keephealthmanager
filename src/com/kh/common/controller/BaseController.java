package com.kh.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.common.model.ResultModel;

public class BaseController {

	@Autowired
	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	protected ResultModel buildResult(boolean success, String msg) {
		ResultModel result = new ResultModel();
		result.setSuccess(success);
		result.setMsg(msg);
		return result;
	}

	protected ResultModel successResult() {
		return buildResult(true, "成功");
	}

	protected ResultModel successResult(String msg) {
		return buildResult(true, msg);
	}

	protected ResultModel failResult(String msg) {
		return buildResult(false, msg);
	}

}
