package com.jumo.loan_accounting.services.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 
 * * The CSVBufferedWriter is composed of a BufferedWriter and rights a text line using 
 * a BufferedReader when given a list of fields.  
 *
 * @author Snyman_T
 */


public class CSVBufferedWriter implements AutoCloseable{
	
	BufferedWriter br;
	
	public CSVBufferedWriter(Path p) throws IOException {
		this.br = Files.newBufferedWriter(p);
	}
	
	
	public void writeCSVLine(List<String> fields) throws IOException{
		
		String line = "";
		
		for(String field : fields){
			
			if(fields.indexOf(field) == fields.size()-1){
				line = line + field;
			}else{
				line = line + field + ",";
			}
		}

		br.write(line + "\n");
		
	}

        /**
         * Required to be able to use this class in a "try with resources" clause
         * 
         * @throws IOException 
         */
	@Override
	public void close() throws IOException{
		br.close();
	}
}
