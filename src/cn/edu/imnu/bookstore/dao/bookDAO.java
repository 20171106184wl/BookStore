package cn.edu.imnu.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.imnu.bookstore.bean.Book;
import cn.edu.imnu.shoppingcar.util.DBUtil;

public class bookDAO {
	public int getRecordCount() {
		int recordCount=0;
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT count(*) FROM tb_book";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				recordCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return recordCount;
	}
	public List<Book> getBookPageList(int pageNo,int pageSize){
		int firstIndex=pageSize*(pageNo-1);
		List<Book>list=new ArrayList<Book>();
		Connection conn=DBUtil.getConnection();
		//if(connection==null) 
			//return null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM tb_book limit ?,?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,firstIndex);
			pstmt.setInt(2,pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getString("book_price"));
				book.setBookWriter(rs.getString("book_writer"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
	public Book getBookInfo(int bookId){
		Connection conn=DBUtil.getConnection();
		//if(connection==null) 
			//return null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Book book=new Book();
		String sql="SELECT * FROM tb_book where book_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			book.setBookId(rs.getInt("book_id"));
			book.setBookName(rs.getString("book_name"));
			book.setBookPrice(rs.getString("book_price"));
			book.setBookWriter(rs.getString("book_writer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return book;
	}
	public int addbook(String name, String price,String writer) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_book(book_name,book_price,book_writer) values(?,?,?)";
		int flag=0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, price);
			pstmt.setString(3,writer);
			pstmt.executeUpdate();
			flag=1;
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		return flag;
	}
	
	public List<Book> searchBookInfo(String bookInfo){
		Connection conn=DBUtil.getConnection();
		//if(connection==null) 
			//return null;
		List<Book>list=new ArrayList<Book>();
		//list=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql = "select * from tb_book where book_name like '%" + bookInfo + "%'";
		try {
			pstmt=conn.prepareStatement(sql);
			//pstmt.setString(1,"%"+bookInfo+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Book book=new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setBookName(rs.getString("book_name"));
				book.setBookPrice(rs.getString("book_price"));
				book.setBookWriter(rs.getString("book_writer"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return list;
	}
}
