<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="webkit" name="renderer">
<link rel="icon"
	href="<%=request.getContextPath()%>/manager/images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/manager/css/login.css" />
<title>登陆界面</title>
</head>
<body>
	<div class="position1">
		<div class="loginBox">
			<div class="clear">
				<div class="title">
					<span>登陆窗口</span>
				</div>
				<div class="formbox">
					<div class="inputbox">
						<span class="label">用户名</span> <input type="text" name="username"
							value="" class="input box" />
					</div>
					<div class="inputbox">
						<span class="label">密码</span> <input type="password"
							name="password" value="" class="input box" />
					</div>
					<div class="inputbox">
						<input type="button" value="登陆" class="input loginbtn" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>