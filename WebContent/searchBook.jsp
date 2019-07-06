<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.edu.imnu.bookstore.dao.bookDAO"%>
<%@ page import="cn.edu.imnu.bookstore.bean.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查找 - Bookstore</title>
<link href="css/base.css" type="text/css" rel="stylesheet" />
<link href="css/my_resume.css" type="text/css" rel="stylesheet" />
<link href="css/register.css" type="text/css" rel="stylesheet" />
</head>
<body>

<iframe src="top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
	<div class="resume_con">
	<div class="page_name">查找</div>
	<div class="login_content">
	
	
<form>
<table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
					  <tr>
					    <th width="110" align="right" bgcolor="#F8F8F8">请输入书名:</th>
					    <td bgcolor="#F8F8F8">
					    <input type="text" name="name"></td>
					  </tr>
					</table>
					<input type ="submit" value="搜索">
</form>

<form action="ShoppingCarServlet" method="post">
<%String bookInfo=request.getParameter("name");
	bookDAO book=new bookDAO();
	List<Book>list=book.searchBookInfo(bookInfo);
	if(list!=null){
		for(Book b:list){
			%>
			<p><input type ="checkbox" name ="book" value="<%=b.getBookId()%>"/><%=b.getBookName()%> <%=b.getBookPrice()%> <%=b.getBookWriter()%></p>
			<%
		}
	}
else{%>
<%} %>

<p><input type ="submit" value="加入购物车"></p>
</form>

</div>
	</div>
<iframe src="foot.jsp" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>	
</body>
</html>