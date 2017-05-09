package com.jumo.loan_accounting.domain;

/**
 *A domain object to represent a Loan. 
 * 
 * @author Snyman_T
 */

import java.util.Date;

public class Loan {
	
	private String msisdn;
	private String network;
	private Date date;
	private String product;
	private double amount;
	
	public Loan(String msisdn,String network,Date date,String product,double amount){
		this.msisdn = msisdn;
		this.network = network;
		this.date = date;
		this.product = product;
		this.amount = amount; 
	}
	
	public String getMSISDN(){
		return this.msisdn;
	}
	
	public String getNetwork(){
		return this.network;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public String getProduct(){
		return this.product;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	
}
