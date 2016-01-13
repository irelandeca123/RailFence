package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser
{
	public Map<String, Double> parse(String file) throws Exception{
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		File File = new File(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(File))); 
		String next=null;
		
		while((next=br.readLine())!=null){
			//Add each line to the parse
			String[] stuff = next.split(" "); //separates the string and score 
			temp.put(stuff[0], Double.parseDouble(stuff[1]));
			//puts the string and score into the quadgram map

		}
		br.close(); //closes bufferdreader
		return temp;
	}
	
}
