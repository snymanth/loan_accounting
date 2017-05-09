package com.jumo.loan_accounting.services.io;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *A LoanOutputCSVFile receives the output file path and tuple totals and makes use of CSVBufferedWriter
 * to write the required Output csv file containing results. 
 * 
 * @author Snyman_T
 */

public class LoanOutputCSVFile{
		
	
	Path path ;
	Map<String,Double> tupleSums;
	Map<String,Integer> tupleCounts;
	
	public LoanOutputCSVFile(Path p, Map<String,Double> tupleSums, Map<String,Integer> tupleCounts){
		this.path = p;
		this.tupleSums = tupleSums;
		this.tupleCounts = tupleCounts;
	}
			
	public void write(){
		
		try(CSVBufferedWriter csvbr = new CSVBufferedWriter(path)){
		
		List<String> headers = new ArrayList<>();	
		headers.add("network");
		headers.add("month");
		headers.add("product");
		headers.add("sum");
		headers.add("count");
		
		csvbr.writeCSVLine(headers);
		
		for(String tuple : tupleSums.keySet()){
	
			List<String> fields = new ArrayList<>();
			fields.add(tuple);
			fields.add(tupleSums.get(tuple).toString());
			fields.add(tupleCounts.get(tuple).toString());
			
			csvbr.writeCSVLine(fields);
		}
		}catch(IOException ioe){
			System.out.println("Problem writing output file: " + ioe.getMessage());
                        System.exit(0);
		}
	}
	
}
