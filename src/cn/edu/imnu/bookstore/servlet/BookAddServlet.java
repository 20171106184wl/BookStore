package cn.edu.imnu.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.imnu.bookstore.bean.Applicant;
import cn.edu.imnu.bookstore.dao.ApplicantDAO;
import cn.edu.imnu.bookstore.dao.bookDAO;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String writer=request.getParameter("writer");
		bookDAO dao = new bookDAO();
		int flag =dao.addbook(name,price,writer);
		if(flag!=0) {
				response.sendRedirect("addBookSuccess.jsp");
		}else {
			out.print("<script type='text/javascript'>");
			out.print("window.location='book.jsp';");
			out.print("</script>");
		}
	}

}
