package com.gft.entity;

public class Test {
	private String smsaddress;
	private String reportdate;
	private String reporttype;
	private int moneyamount;
	private int sendamount;

	public Test(String smsaddress, String reportdate, String reporttype, int moneyamount, int sendamount) {
		super();
		this.smsaddress = smsaddress;
		this.reportdate = reportdate;
		this.reporttype = reporttype;
		this.moneyamount = moneyamount;
		this.sendamount = sendamount;
	}

	public Test() {
		super();
	}

	public String getSmsaddress() {
		return smsaddress;
	}

	public void setSmsaddress(String smsaddress) {
		this.smsaddress = smsaddress;
	}

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public String getReporttype() {
		return reporttype;
	}

	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}

	public int getMoneyamount() {
		return moneyamount;
	}

	public void setMoneyamount(int moneyamount) {
		this.moneyamount = moneyamount;
	}

	public int getSendamount() {
		return sendamount;
	}

	public void setSendamount(int sendamount) {
		this.sendamount = sendamount;
	}

}
