package com.jumo.loan_accounting.services.io;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The CSVBufferedReader is composed of a BufferedReader and implements functionality to 
 * read a CSV line and return all the fields as a List.  
 *
 * @author Snyman_T
 */
public class CSVBufferedReader implements AutoCloseable{
	
	BufferedReader br;
	Scanner sc;

	public CSVBufferedReader(Path p) throws IOException{	
		this.br = Files.newBufferedReader(p);
	}
	
	public List<String> readCSVLine() throws IOException{
		
		String line;

		if((line = br.readLine()) != null){
			sc = new Scanner(line);
			sc.useDelimiter(",");
			List<String> list = new ArrayList<>(); 
			
			while(sc.hasNext()){
				list.add(sc.next());
			}
			
			return list;
			
		}else{
			return null;
		}	
	}

        
        /**
         * Required to be able to use this class in a "try with resources" clause
         * 
         * @throws IOException 
         */
	@Override
	public void close() throws IOException{
		br.close();
		sc.close();
	}

}