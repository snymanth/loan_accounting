package com.jumo.loan_accounting.services;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jumo.loan_accounting.domain.Loan;

/**
 * The LoanAnalyser object is responsible for calculating the tuple totals when given a List of Loans.
 * It also returns Maps to provide the sums and counts for each of the tuples 
 *
 * @author Snyman_T
 */
public class LoanAnalyser {
    
    List<Loan> loans = new ArrayList<>();
	Map<String,Double> tupleSums = new HashMap<>();
	Map<String,Integer> tupleCounts = new HashMap<>();
	
	public LoanAnalyser(List<Loan> loans){
		this.loans = loans;
	}
	
	
	public void calculateTupleTotals(){

		
		for(Loan l : loans){
			SimpleDateFormat formatter =  new SimpleDateFormat("MMM");			
			String tuple = l.getNetwork()+","+ formatter.format(l.getDate())+","+l.getProduct();
			
			if(!tupleSums.containsKey(tuple)){
				tupleSums.put(tuple,l.getAmount());
				tupleCounts.put(tuple,1);
			}else{
				tupleSums.replace(tuple,tupleSums.get(tuple) + l.getAmount());
				tupleCounts.replace(tuple,tupleCounts.get(tuple) + 1);
			}
		}
	}
	
	public Map<String, Double> getTupleSums(){
		return this.tupleSums;
	}
	
	public Map<String, Integer> getTupleCounts(){
		return this.tupleCounts;
	}
    
    
}

