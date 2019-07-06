<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加书籍 - Bookstore</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
<link href="css/my_resume.css" type="text/css" rel="stylesheet" />
</head>
	<body>
		<iframe src="top.jsp" width="100%" height="100" scrolling="no"
			frameborder="0"></iframe>
		<div class="content">
			<div class="page_name">添加书籍</div>
			<div class="login_content">

				<form action = "BookAddServlet" method = "post">
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">书名:</th>
					    <td bgcolor="#F8F8F8">
					    <input type="text" name="name"></td>
					  </tr>
					</table>
					
						<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">价格:</th>
					    <td bgcolor="#F8F8F8">
					    <input type="text" name="price"></td>
					  </tr>
					</table>
					
					<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">作者:</th>
					    <td bgcolor="#F8F8F8">
					    <input type="text" name="writer"></td>
					  </tr>
					</table>
					
					<p><input type ="submit" value="提交"></p>
					</form>
					<iframe src="foot.jsp" width="100%" height="150" scrolling="no"
		frameborder="0"></iframe>
</body>
</html>