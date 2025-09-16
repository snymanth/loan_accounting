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
    
    private final List<Loan> loans;
    private final Map<String, Double> tupleSums = new HashMap<>();
    private final Map<String, Integer> tupleCounts = new HashMap<>();
    
    // Pre-create formatter to avoid creating it in the loop - significant performance improvement
    private static final SimpleDateFormat MONTH_FORMATTER = new SimpleDateFormat("MMM");
    
    public LoanAnalyser(List<Loan> loans) {
        this.loans = loans != null ? loans : new ArrayList<>();
    }
    
    public void calculateTupleTotals() {
        if (loans.isEmpty()) {
            return;
        }
        
        for (Loan loan : loans) {
            if (loan == null || loan.getDate() == null) {
                continue; // Skip invalid loans
            }
            
            // Build tuple key more efficiently
            StringBuilder tupleBuilder = new StringBuilder();
            tupleBuilder.append(loan.getNetwork())
                       .append(",")
                       .append(MONTH_FORMATTER.format(loan.getDate()))
                       .append(",")
                       .append(loan.getProduct());
            String tuple = tupleBuilder.toString();
            
            // Use merge operations for better performance - single map operation instead of contains/get/replace
            tupleSums.merge(tuple, loan.getAmount(), Double::sum);
            tupleCounts.merge(tuple, 1, Integer::sum);
        }
    }
    
    public Map<String, Double> getTupleSums() {
        return this.tupleSums;
    }
    
    public Map<String, Integer> getTupleCounts() {
        return this.tupleCounts;
    }
}

