package cn.edu.imnu.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.bookstore.dao.ApplicantDAO;

/**
 * Servlet implementation class ApplicantRegisterServlet
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String verifyCode=request.getParameter("verifyCode");
		String sessionValidateCode=(String)request.getSession().getAttribute("SESSION_VALIDATECODE");
//		System.out.println(verifyCode);
//		System.out.println(sessionValidateCode);
		if(!sessionValidateCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('请输入正确验证码！');");
			out.print("window.location='register.jsp';");
			out.print("</script>");
		}else {
			ApplicantDAO dao = new ApplicantDAO();
			boolean flag=dao.isExistEmail(email);
			if(flag)
			{
				out.print("<script type='text/javascript'>");
				out.print("alert('邮箱已被注册，请重新输入！');");
				out.print("window.location='register.jsp';");
				out.print("</script>");
			}else {
				dao.save(email,password);
				response.sendRedirect("login.jsp");
			}
		}
	}

}
