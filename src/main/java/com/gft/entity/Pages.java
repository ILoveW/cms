package com.gft.entity;

public class Pages {
	/**
	 * 
	 * @author shixi
	 *
	 */
	private int rows;
	private int page; // 每页显示记录的条数
	private String name;
	private String tel;
	private String email;
	private String id;
	private String bewrite;
	private String url;
	private String uname;
	private String role_name;
	


	public String getRole_name() {
		return role_name;
	}

	public Pages(String name, String url, int rows, int page,String role_name) {
		super();
		this.rows = rows;
		this.page = page;
		this.name = name;
		this.url = url;
		this.role_name = role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBewrite() {
		return bewrite;
	}

	public void setBewrite(String bewrite) {
		this.bewrite = bewrite;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Pages(int rows, int page) {
		super();
		this.rows = rows;
		this.page = page;
	}
	public Pages(String name,String tel,String email, int page, int rows) {
		super();
		this.rows = rows;
		this.page = page;
		this.name = name;
		this.tel=tel;
		this.email=email;
	}
	public Pages(String id,String name,int page,String bewrite,  int rows) {
		super();
		this.rows = rows;
		this.page = page;
		this.name = name;
		this.id=id;
		this.bewrite=bewrite;
	}
	
	public Pages(int rows, int page, String name, String url) {
		super();
		this.rows = rows;
		this.page = page;
		this.name = name;
		this.url = url;
	}

	public Pages(int rows, int page, String name, String bewrite, String uname) {
		super();
		this.rows = rows;
		this.page = page;
		this.name = name;
		this.bewrite = bewrite;
		this.uname = uname;
	}

	public Pages() {

	}
}