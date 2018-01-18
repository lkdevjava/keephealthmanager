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
	href="<%=request.getContextPath()%>/manager/css/login.css?_=<%=System.currentTimeMillis()%>" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/manager/js/jquery-1.12.4.min.js?_=<%=System.currentTimeMillis()%>"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/manager/js/jquery.message.js?_=<%=System.currentTimeMillis()%>"></script>
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
					<form action="<%=request.getContextPath()%>/login" method="post">
						<div class="inputbox">
							<span class="label">用户名</span> <input type="text" name="username"
								id="username" value="admin" class="input box" />
						</div>
						<div class="inputbox">
							<span class="label">密码</span> <input type="password"
								name="password" id="password" value="123456789"
								class="input box" />
						</div>
						<div class="inputbox">
							<input type="submit" value="登陆" class="input loginbtn"
								id="loginBth" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="msg"></div>
	<script type="text/javascript">
		$(function() {
			$('#msg').showSuccessMessage('<%=request.getAttribute("message")%>');
		});
	</script>
</body>
</html>