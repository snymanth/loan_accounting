package com.jumo.loan_accounting.services.io;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * A LoanInputCSVFile receives the path to the input csv file and makes use of a CSVBufferedReader 
 * to return a list of Loans in the file
 *
 * @author Snyman_T
 */


import com.jumo.loan_accounting.domain.Loan;

public class LoanInputCSVFile {
	
	Path p;
	//List<String> headers;
	
	public LoanInputCSVFile(Path p){
		this.p = p;
	}
	
	public List<Loan> readLoans() throws ParseException {
		
		try(CSVBufferedReader csvbr = new CSVBufferedReader(p)){
		
			List<String> headers = csvbr.readCSVLine();
			
			List<Loan> ll = new ArrayList<>();
			List<String> fields;
			SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
			
			while((fields = csvbr.readCSVLine()) != null){
				
				String msisdn = fields.get(headers.indexOf("MSISDN"));
				String network = fields.get(headers.indexOf("Network")).replaceAll("'","");
				Date date = dateFormatter.parse(fields.get(2).replaceAll("'",""));
				String product = fields.get(headers.indexOf("Product")).replaceAll("'","");
				double amount = Double.parseDouble(fields.get(4).replaceAll("'",""));
	
				ll.add(new Loan(msisdn,network,date,product,amount));
				
				
			}
		
			return ll;	
		
		}catch(IOException ioe){
			System.out.println("Problem reading input file: " + ioe.getMessage());
			System.exit(0);
			return null;
		}
		
		
		
		
	}

}
