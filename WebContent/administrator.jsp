<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录 - Bookstore</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/login.css" type="text/css" rel="stylesheet" /> 
</head>
<body>
<%
	String applicantEmail="";
String applicantPwd="";
Cookie [] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie cookie:cookies){
		if("COOKIE_APPLICANTEMAIL".equals(cookie.getName())){
			applicantEmail=cn.edu.imnu.shoppingcar.util.CookieEncryptTool.decodeBase64(cookie.getValue());
		}
		if("COOKIE_APPLICANTPWD".equals(cookie.getName())){
			applicantPwd=cn.edu.imnu.shoppingcar.util.CookieEncryptTool.decodeBase64(cookie.getValue());
		}
		
	}
}
%>
	<iframe src="top.jsp" width="100%" height="100" scrolling="no"
		frameborder="0"></iframe>
	<div class="content">
		<div class="page_name">管理员登陆</div>
		<div class="login_content">
			<form action="AdministratorLoginServlet" method="POST">
			<div class="login_l">
				<p class="font14">使用管理员账号登录</p>
				<div class="span1">
					<label class="tn-form-label">账号：</label> 
					<input class="tn-textbox" name="email" type="text" value="<%=applicantEmail%>">
				</div>
				<div class="span1">
					<label class="tn-form-label">密码：</label> 
					<input class="tn-textbox" name="password" type="password" value="<%=applicantPwd%>">
				</div>
				<div class="tn-form-row-button">
					<div class="span1">
						<input name="" type="submit" class="tn-button-text" value="登   录">
						<span class="it-register-text"> <input checked="checked" name="rememberMe" id="rememberMe"
							class="tn-checkbox" value="true" type="checkbox"> 
							<label
							for="RememberPassword"> 记住密码</label>
						</span>
					</div>
			</form>
				</div>
				<div class="clear"></div>
			</div>
			<div class="login_r">

				<div>
					<img src="images/login_pic3.png">
				</div>

				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>