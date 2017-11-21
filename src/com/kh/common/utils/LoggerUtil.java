package com.kh.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerUtil {

    private static boolean isdebug = LogFactory.getLog(LoggerUtil.class)
	    .isDebugEnabled();

    /**
     * 实现 : 打印info级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     */
    public static void info(Class<? extends Object> clazz, String msg) {
	Log classLog = LogFactory.getLog(clazz);
	classLog.info(msg);
    }

    /**
     * 实现: 打印带参数的info级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     * @param objs
     *            信息中的参数
     */
    public static void formateinfo(Class<? extends Object> clazz, String msg,
	    Object... objs) {
	if (StringUtils.isBlank(msg)) {
	    return;
	}
	if (objs != null && objs.length > 0) {
	    msg = String.format(msg, objs);
	}
	info(clazz, msg);
    }

    /**
     * 实现: 打印debug级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     */
    public static void debug(Class<? extends Object> clazz, String msg) {
	if (!isdebug) {
	    return;
	}
	Log classLog = LogFactory.getLog(clazz);
	classLog.debug(msg);
    }

    /**
     * 实现: 打印带参数的debug级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     * @param objs
     *            信息中的参数
     */
    public static void formatedebug(Class<? extends Object> clazz, String msg,
	    Object... objs) {
	if (!isdebug) {
	    return;
	}
	if (StringUtils.isBlank(msg)) {
	    return;
	}
	if (objs != null && objs.length > 0) {
	    msg = String.format(msg, objs);
	}
	debug(clazz, msg);
    }

    /**
     * 实现: 打印error级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     */
    public static void error(Class<? extends Object> clazz, String msg) {
	Log classLog = LogFactory.getLog(clazz);
	classLog.error(msg);
    }

    /**
     * 实现: 打印带参数的error级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param msg
     *            打印信息
     * @param objs
     *            信息中的参数
     */
    public static void error(Class<? extends Object> clazz, String msg,
	    Object... objs) {
	if (StringUtils.isBlank(msg)) {
	    return;
	}
	if (objs != null && objs.length > 0) {
	    msg = String.format(msg, objs);
	}
	error(clazz, msg);
    }

    /**
     * 实现: 打印error级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param e
     *            异常
     * @param msg
     *            打印信息
     */
    public static void error(Class<? extends Object> clazz, Exception e,
	    String msg) {
	Log classLog = LogFactory.getLog(clazz);
	classLog.error(msg, e);
    }

    /**
     * 实现: 打印error级别信息
     * 
     * @param clazz
     *            信息所在的类
     * @param e
     *            异常
     * @param msg
     *            打印信息
     * @param objs
     *            信息中的参数
     */
    public static void error(Class<? extends Object> clazz, Exception e,
	    String msg, Object... objs) {
	Log classLog = LogFactory.getLog(clazz);
	classLog.error(msg, e);
	if (StringUtils.isBlank(msg)) {
	    return;
	}
	if (objs != null && objs.length > 0) {
	    msg = String.format(msg, objs);
	}
	error(clazz, e, msg);
    }

}
