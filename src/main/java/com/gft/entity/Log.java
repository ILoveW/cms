package com.gft.entity;

import java.io.Serializable;

public class Log implements Serializable{
	private String Log_id;
	private String Method;
	private String Uname;
	private String AddTime;
	private String Content;
	private String LoginName;
	public Log() {
		super();
	}
	public Log(String log_id, String method, String uname, String addTime, String content, String loginName) {
		super();
		Log_id = log_id;
		Method = method;
		Uname = uname;
		AddTime = addTime;
		Content = content;
		LoginName = loginName;
	}
	public String getLog_id() {
		return Log_id;
	}
	public void setLog_id(String log_id) {
		Log_id = log_id;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getAddTime() {
		return AddTime;
	}
	public void setAddTime(String addTime) {
		AddTime = addTime;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

}
