package com.yc.jdbc.dao;

import com.yc.jdbc.Utils.JDBCUtilsByDruid;
import com.yc.jdbc.domain.BookAndBorrow;
import com.yc.jdbc.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BasicDAO<User>{

	public static List<BookAndBorrow> listBook(String userId) {
		//String sql ="select * from books, borrow where books.ISN = borrow.ISN";
		String sql = "SELECT b.title, b.author, b.ISN, br.borrow_date FROM borrow br " +
				"JOIN users u ON br.user_id = u.user_id JOIN books b ON br.ISN = b.ISN " +
				"WHERE u.user_id = ? and br.return_date is null ";



		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;

	
			
			try {
				conn = JDBCUtilsByDruid.getConnection();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			List<BookAndBorrow> list = new ArrayList<BookAndBorrow>();
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId); // set userId
			rs = ps.executeQuery();
			while(rs.next()) {
				int isn = rs.getInt("isn");
				String author = rs.getString("author");
				String title = rs.getString("title");
				Date borrow_date = rs.getDate("borrow_date");
				BookAndBorrow bookAndBorrow = new BookAndBorrow(isn,author,title,borrow_date);
				list.add(bookAndBorrow);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCUtilsByDruid.close(rs, ps, conn);
		}
		return list;
	}
}
