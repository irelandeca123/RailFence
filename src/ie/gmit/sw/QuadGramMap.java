package ie.gmit.sw;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap
{
	public static final int GRAM_SIZE=4;
	private static Map<String, Double> map = new ConcurrentHashMap<String, Double>(); //map for QuadGram file contents
	private static FileParser fileParser = new FileParser();//create new instance of FileParser
	
	public QuadGramMap()
	{
		super();
	}
	public static Map<String, Double> getMap()
	{
		return map;
	}
	public static void setMap()
	{
		String File = "4grams.txt";
		
		try
		{
			map = fileParser.parse(File);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int getGramSize()
	{
		return GRAM_SIZE;
	}
	
}
