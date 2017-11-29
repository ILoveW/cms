package com.gft.entity;

public class Temp {

	/**
	 * 用户表实体类
	 * 
	 * @author shixi
	 *
	 */
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_tel;
	private String user_email;
	private String user_adress;
	private String user_date;
	private String user_state;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_adress() {
		return user_adress;
	}

	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public Temp() {
		super();
	}

	public Temp(String user_id, String user_name, String user_password, String user_tel, String user_email,
			String user_adress, String user_date, String user_state) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_tel = user_tel;
		this.user_email = user_email;
		this.user_adress = user_adress;
		this.user_date = user_date;
		this.user_state = user_state;
	}

}
