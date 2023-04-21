package com.yc.jdbc.domain;

import java.sql.Date;

public class Borrow {

	private int id;
	private String user_id;
	private int isn;
	private Date borrow_date;
	private Date return_date;
	
	public Borrow() {
	}

	public Borrow(int id, String user_id, int isn, Date borrow_date, Date return_date) {
		this.id = id;
		this.user_id = user_id;
		this.isn = isn;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
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

	public int getIsn() {
		return isn;
	}

	public void setIsn(int isn) {
		this.isn = isn;
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
		return "Borrow [id=" + id + ", user_id=" + user_id + ", isn=" + isn + ", borrow_date=" + borrow_date
				+ ", return_date=" + return_date + "]";
	}

	
}
