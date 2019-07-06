package cn.edu.imnu.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.imnu.bookstore.bean.Book;
import cn.edu.imnu.bookstore.dao.bookDAO;
import cn.edu.imnu.bookstore.servlet.LogoutServlet;
/**
 * Servlet implementation class ShoppingListServlet
 */
@WebServlet("/ShoppingListServlet")
public class ShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		
		HttpSession session=request.getSession();
		Map<String,Integer>car=(Map<String,Integer>)session.getAttribute("shoppingCar");
		bookDAO dao=new bookDAO();
		Book cars=new Book();
		
		double allprice=0;
		out.println("<title>购物车 - Bookstore</title>");
		out.println("<link href=\"css/my_resume.css\" type=\"text/css\" rel=\"stylesheet\" />");
		out.println("<link href=\"css/register.css\" type=\"text/css\" rel=\"stylesheet\" />");
		out.println("<link href=\"css/base.css\" type=\"text/css\" rel=\"stylesheet\" />");
		
		out.println("<iframe src=\"top.jsp\" width=\"100%\" height=\"100\"  scrolling=\"no\" frameborder=\"0\" ></iframe>");
		
		out.println("<div class=\"resume_con\">");
		if(car!=null&&car.size()>0) {
			out.println("<div class=\"page_name\">购物车</div>");
			out.println("<div class=\"login_content\">");
			for(String bookName:car.keySet()) {
				int bookId=Integer.parseInt(bookName);
				cars=dao.getBookInfo(bookId);
				out.println("<p>"+cars.getBookName()+" "+cars.getBookPrice()+" "+cars.getBookWriter()+" "+car.get(bookName)+"本</p>");
				allprice=allprice+car.get(bookName)*Float.parseFloat(cars.getBookPrice());
			}
			out.println("<p>总价:"+allprice+"</p>");
		}else {
			out.println("<p>您没有购买任何书籍</p>");
		}
		out.println("<a href=\"bookChoose.jsp\"><span class=\"type1\">继续购买</a>");
		out.println("<a href=\"searchBook.jsp\"><span class=\"type1\">搜索</a>");
		out.println("<a href=\"LogoutServlet\"><span class=\"type1\">退出</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("<iframe src=\"foot.jsp\" width=\"100%\" height=\"150\"  scrolling=\"no\" frameborder=\"0\" ></iframe>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
