<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册 - Bookstore</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
<meta
	content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职"
	name="keywords">
<meta
	content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。"
	name="description">
  <script type="text/javascript">
	function validate(){
		var email =document.getElementById("email");
		var password = document.getElementById("password");
		var agree = document.getElementById("agree");
		var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if(email.value==""){
			alert("邮箱不能为空！");
			email.focus();
			return false;
		}else if(!pattern.test(email.value)){
			alert("请输入正确的邮箱格式!");
			email.focus();
			return false;
		}
		if(password.value==""){
			alert("密码不能为空！");
			password.focus();
			return false;
		}else if(password.length<6||password.length>12){
			alert("密码长度不符合要求，请输入6~12位密码！");
			password.focus();
			return false;
		}
		if(!agree.checked){
			alert("请先同意本站服务条款！");
			return false;
		}
		return true;
	}
	function showdiv(){
		document.getElementById("bg").style.display="block";
		document.getElementById("show").style.display="block";
	}
	function hidediv(){
		document.getElementById("bg").style.display="none";
		document.getElementById("show").style.display="none";
	}
	function changeValidateCode(){
		document.getElementById("validateCode").src="ValidateCodeServlet?rand="+Math.random();
	}
</script>


</head>
	<body>
		<iframe src="top.jsp" width="100%" height="100" scrolling="no"
			frameborder="0"></iframe>
		<div class="content">
			<div class="page_name">注册</div>
			<div class="login_content">
			<form action="ApplicantRegisterServlet" method="POST" onsubmit = "return validate();">
				<div class="login_l">
					<div class="span1">
						<label class="tn-form-label">邮箱：</label> <input class="tn-textbox"
							name="email" type="text"> 
					</div>
					<div class="span1">
						<label class="tn-form-label">密码：</label> <input class="tn-textbox"
							type="password" name="password" id="password">
					</div>
					<div class="span1">
						<label class="tn-form-label">验证码：</label> <input
							class="tn-textbox-long" type="text" name="verifyCode"> <span> <img
							src="ValidateCodeServlet" title="点击换一换" id="validateCode" onclick="changeValidateCode()"> <a
							href="javascript:changeValidateCode();">看不清？</a>
						</span>
					</div>
					<div class="tn-form-row-button">
						<div class="span1">
							<input name="" type="submit" class="tn-button-text" value="立即注册">
							<p class="it-register-text">
								<input name="" id="" class="tn-checkbox" value="true"
									checked="checked" type="checkbox"> <label>
									同意本站服务条款</label> <a href="javascript:;">查看</a>
							</p>
						</div>
					</div>
					<div class="clear"></div>
				</div>
</form>
<div class="register_r">
	<p align="center">
		<b>还没有帐号？</b><a href="register.jsp">10秒钟快速注册</a>
	</p>

	<div>
		<img src="images/reg_pic.png">
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