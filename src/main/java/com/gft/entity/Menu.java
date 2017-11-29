package com.gft.entity;

public class Menu {
	private String menu_id;
	private String menu_name;
	private String menu_fid;
	private String menu_url;
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_fid() {
		return menu_fid;
	}
	public void setMenu_fid(String menu_fid) {
		this.menu_fid = menu_fid;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public Menu() {
		super();
	}
	public Menu(String menu_id, String menu_name, String menu_fid, String menu_url) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_fid = menu_fid;
		this.menu_url = menu_url;
	}
	
}
