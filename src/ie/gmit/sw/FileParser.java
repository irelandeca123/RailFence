package ie.gmit.sw;

import java.awt.List;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.*;

import junit.framework.Test;


public class FileParser {
	
	public static String file = "C:\\Users\\Stoyan_R\\workspace\\A Multi-threaded Cypher Breaker\\bin\\ie\\gmit\\sw\\4grams.txt";
	public static String map1="";
	public static Map<String, Double> map = new ConcurrentHashMap<String, Double>();

    public void readFromFile(String file) throws IOException {

        String text = file;
        // Hello contains:
        // HELLO 12312
        // BYE 12213
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(text), Charset.forName("UTF-8")));

        while ((text = reader.readLine()) != null) {
            // Splits the read line in two where the space char is the
            // separating
            String[] stuff = text.split(" ");

            map.put(stuff[0], Double.parseDouble(stuff[1]));

        }
    }

    public static void main(String[] args) throws IOException {
    	FileParser t = new FileParser();
        t.readFromFile(file);
        map1 += map;
        System.out.println(map1);

    }
    
}