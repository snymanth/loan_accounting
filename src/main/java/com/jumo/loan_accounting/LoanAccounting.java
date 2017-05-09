/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jumo.loan_accounting;

import java.nio.file.Paths;
import java.util.List;
import com.jumo.loan_accounting.domain.Loan;
import com.jumo.loan_accounting.services.LoanAnalyser;
import com.jumo.loan_accounting.services.io.LoanInputCSVFile;
import com.jumo.loan_accounting.services.io.LoanOutputCSVFile;

/**
 *
 * @author Snyman_T
 */
public class LoanAccounting {
    
    public static void main(String[] args) throws Exception{
		
		
		LoanInputCSVFile loanInputCSVFile = new LoanInputCSVFile(Paths.get(args[0]));
	
		List<Loan> loanList = loanInputCSVFile.readLoans();
		
		LoanAnalyser la = new LoanAnalyser(loanList);

		la.calculateTupleTotals();
		
		LoanOutputCSVFile outputCSVFile = new LoanOutputCSVFile(Paths.get("Output.csv"),la.getTupleSums(),la.getTupleCounts());
		outputCSVFile.write();

	}
    
}
