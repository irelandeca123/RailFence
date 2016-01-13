package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader
{
	public String readFile(String file) throws IOException{
		
		StringBuilder sb = new StringBuilder(); 
		
		File f=new File(file); //passes on file from user
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f))); 
		
		String line;  // in order to read line by line
				
		while((line=br.readLine())!=null){ 
			
			sb.append(line);			
		}
		
		br.close();
		
		file=sb.toString();	// convert stringbuilder to string
		
		return file;
		
	}
}
