package com.springreactive.bms.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Loan {
	
	private String username;
	private String loantype;
	private long loanamount;
	private String date;
	private long rateofinterest;
	private long durationofloan;
	public Loan() {
		
		}
	public Loan(String username, String loantype, long loanamount, String date, long rateofinterest,
			long durationofloan) {
		super();
		this.username = username;
		this.loantype = loantype;
		this.loanamount = loanamount;
		this.date = date;
		this.rateofinterest = rateofinterest;
		this.durationofloan = durationofloan;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoantype() {
		return loantype;
	}
	public void setLoantype(String loantype) {
		this.loantype = loantype;
	}
	public long getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(long loanamount) {
		this.loanamount = loanamount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getRateofinterest() {
		return rateofinterest;
	}
	public void setRateofinterest(long rateofinterest) {
		this.rateofinterest = rateofinterest;
	}
	public long getDurationofloan() {
		return durationofloan;
	}
	public void setDurationofloan(long durationofloan) {
		this.durationofloan = durationofloan;
	}
	@Override
	public String toString() {
		return "Loan [username=" + username + ", loantype=" + loantype + ", loanamount=" + loanamount + ", date=" + date
				+ ", rateofinterest=" + rateofinterest + ", durationofloan=" + durationofloan + "]";
	}
	

}
//Loan Type, Loan Amount, Date, Rate of Interest and Duration of Loan.