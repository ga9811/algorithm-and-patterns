package com.yc.jdbc.service;

import com.yc.jdbc.dao.BasicDAO;
import com.yc.jdbc.dao.UserDAO;
import com.yc.jdbc.domain.BookAndBorrow;
import com.yc.jdbc.domain.Books;
import com.yc.jdbc.domain.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    private BasicDAO<Books> booksDAO = new BasicDAO<>();
    private BasicDAO<BookAndBorrow> bookAndBorrowDAO = new BasicDAO<>();

    public User getUserByIdAndPwd(String user_id, String pwd, int userType) {
        User user = userDAO.querySingle("select * from users where user_id =? and pwd = md5(?) and user_type =?",
                User.class, user_id, pwd, userType);
        return user;
    }
    public int updateUser(String user_id, String pwd,String name, int user_type) {
        int user = userDAO.update("insert into users (user_id, pwd, name,user_type) values (?,md5(?),?,?)",
                user_id, pwd, name, user_type);
        return user;
    }
    
    public Books getBookInformationsByISN(int ISN) {
    	String sql = "SELECT * FROM books WHERE ISN = ?";
    	return booksDAO.querySingle(sql, Books.class, ISN);
    }
    
    public boolean updateBookInformation(Books updatedBook) {
        String sql = "UPDATE books SET title = ?, author = ?, price = ?, "
        		+ "publisher = ?,bookTypeId =?,available = ? WHERE ISN = ?";
        int rowsAffected = booksDAO.update(sql, updatedBook.getTitle(), 
        		updatedBook.getAuthor(), updatedBook.getPrice(), updatedBook.getPublisher(), 
        		updatedBook.getBookTypeId(),updatedBook.getAvailable(),updatedBook.getIsn());
        System.out.println("Rows affected: " + rowsAffected); // Print the number of rows affected
        return rowsAffected > 0;
    }


    //searchBooksByTitle used in mybooks
    public List<Books> searchBooksByTitle(String title) {
        return booksDAO.queryMulti("SELECT ISN, title, author, publisher, available FROM books WHERE title LIKE ?",
                Books.class, "%" + title + "%");
    }
    // searchBooksByTitleByAdmin used in admin update
    public List<BookAndBorrow> searchBooksByTitleByAdmin(String title) {
        return bookAndBorrowDAO.queryMulti("SELECT b.ISN, u.user_id, b.title, " +
                "b.author, br.borrow_date, br.return_date, b.publisher, b.available " +
                "FROM books AS b LEFT JOIN borrow AS br " +
                "ON b.ISN = br.ISN LEFT JOIN users AS u " +
                "ON br.user_id = u.user_id WHERE b.title LIKE ?", BookAndBorrow.class, "%" + title + "%");


    }

    public List<Books> searchBooksByAuthor(String author) {
        return booksDAO.queryMulti("SELECT ISN, title, author, publisher, available FROM books WHERE author LIKE ?",
                Books.class, "%" + author + "%");
    }
    public List<Books> searchBooksByPublisher(String publisher) {
        return booksDAO.queryMulti("SELECT ISN, title, author, publisher, available FROM books WHERE publisher LIKE ?",
                Books.class, "%" + publisher + "%");
    }

    public boolean borrowBook(String userId, String bookId) {
        String borrowSql = "INSERT INTO borrow (user_id, ISN, borrow_date) VALUES (?, ?, ?)";
        String updateBookSql = "UPDATE books SET available = 1 WHERE ISN = ?";
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        int borrowResult = bookAndBorrowDAO.update(borrowSql, userId, bookId, sqlDate);
        int updateBookResult = booksDAO.update(updateBookSql, bookId);

        return borrowResult > 0 && updateBookResult > 0;
    }
    public boolean returnBook(String userId, int ISN) {
        String returnSql = "UPDATE borrow SET return_date = ? WHERE user_id = ? AND ISN = ? AND return_date IS NULL";
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

        int returnResult = bookAndBorrowDAO.update(returnSql, sqlDate, userId, ISN);
        if (returnResult > 0) {
            String updateBookSql = "UPDATE books SET available = 0 WHERE ISN = ?";
            int updateBookResult = booksDAO.update(updateBookSql, ISN);
            return updateBookResult > 0;
        } else {
            return false;
        }
    }
	public List<BookAndBorrow> searchBooksByUserId(String user_id) {
		return bookAndBorrowDAO.queryMulti("SELECT b.ISN, u.user_id, b.title, b.author, br.borrow_date, "
				+ "br.return_date, b.publisher, b.available "
				+ "FROM books AS b "
				+ "JOIN borrow AS br "
				+ "ON b.ISN = br.ISN "
				+ "JOIN users AS u "
				+ "ON br.user_id = u.user_id "
				+ "WHERE u.user_id = ?", BookAndBorrow.class, user_id);
	}
	public boolean deleteBook(int isn) {
		String sql = "DELETE FROM books WHERE ISN = ?";
		int rowsAffected = booksDAO.update(sql, isn);
		return rowsAffected > 0;
	}
	public boolean insertBook(Books addBook) {
		String sql = "INSERT INTO books (ISN, title, author, price, publisher,bookTypeId, available)"
				+ "VALUES (?, ?, ?, ?, ?,?,?)";
		int rowsAffected = booksDAO.update(sql, addBook.getIsn(),addBook.getTitle(), 
				addBook.getAuthor(), addBook.getPrice(), addBook.getPublisher(), 
				addBook.getBookTypeId(),addBook.getAvailable());
        System.out.println("Rows affected: " + rowsAffected); // Print the number of rows affected
        return rowsAffected > 0;
	}



}




