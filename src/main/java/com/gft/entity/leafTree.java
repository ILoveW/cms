package com.gft.entity;

public class leafTree {

	/**
	 * 用户菜单实体类
	 * 
	 * @author shixi
	 *
	 */
	private int id;
	private int fid;
	private String name;
	private String text;

	public leafTree(int id, int fid, String name, String text) {
		super();
		this.id = id;
		this.fid = fid;
		this.name = name;
		this.text = text;
	}

	public leafTree() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
