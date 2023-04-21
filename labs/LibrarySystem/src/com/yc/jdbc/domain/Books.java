package com.yc.jdbc.domain;

public class Books {
/*
 * book_id INT PRIMARY KEY auto_increment,
 * ISN int, title VARCHAR(100), 
	author VARCHAR(100), 
	price DECIMAL(5,2), 
	bookTypeId int, 
	available int, 
 */
	private int book_id;
	private int isn;
	private String title;
	private String author;
	private double price;
	private int bookTypeId;
	private int available;
	private String publisher;
	
	
	public Books() {
	}


	public Books(int isn, String title, String author, double price,  String publisher,int bookTypeId, int available) {
		
		this.isn = isn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.available = available;
		this.publisher = publisher;
	}


	public Books(int book_id, int isn, String title,String author, double price,String publisher, int bookTypeId, int available) {
		this.book_id = book_id;
		this.isn = isn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.available = available;
		this.publisher = publisher;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", isn=" + isn + ", title=" + title + ", author=" + author + ", price="
				+ price + ", bookTypeId=" + bookTypeId + ", available=" + available + ", publisher=" + publisher + "]";
	}
	
	
}
