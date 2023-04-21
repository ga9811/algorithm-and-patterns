package com.yc.jdbc.domain;

import java.sql.Date;

public class BookAndBorrow {

	private int book_id;
	private int isn;
	private String title;
	private String author;
	private double price;
	private int bookTypeId;
	private int available;
	private int id;
	private String user_id;
	private Date borrow_date;
	private Date return_date;
	private String publisher;
	
	public BookAndBorrow() {
	}


	public BookAndBorrow(int book_id, int isn, String title, String author, double price, int bookTypeId, int available,
			int id, String user_id, Date borrow_date, Date return_date, String publisher) {
		this.book_id = book_id;
		this.isn = isn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.available = available;
		this.id = id;
		this.user_id = user_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		this.publisher = publisher;
	}


	public BookAndBorrow(int book_id, int isn,String title, String author, double price, int bookTypeId, int available, int id,
			String user_id, Date borrow_date, Date return_date) {
		this.book_id = book_id;
		this.isn = isn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.available = available;
		this.id = id;
		this.user_id = user_id;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
		
	}
	

	public BookAndBorrow(int isn, String author, String title, Date borrow_date) {

		this.isn = isn;
		this.title = title;
		this.author = author;
		this.borrow_date = borrow_date;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public int getIsn() {
		return isn;
	}


	public void setIsn(int isn) {
		this.isn = isn;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getBookTypeId() {
		return bookTypeId;
	}


	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}


	public int getAvailable() {
		return available;
	}


	public void setAvailable(int available) {
		this.available = available;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public Date getBorrow_date() {
		return borrow_date;
	}


	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}


	public Date getReturn_date() {
		return return_date;
	}


	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}


	@Override
	public String toString() {
		return "BookAndBorrow [book_id=" + book_id + ", isn=" + isn + ", title=" + title + ", author=" + author
				+ ", price=" + price + ", bookTypeId=" + bookTypeId + ", available=" + available + ", id=" + id
				+ ", user_id=" + user_id + ", borrow_date=" + borrow_date + ", return_date=" + return_date
				+ ", publisher=" + publisher + "]";
	}
	
	
}
