package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable
{
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private static RailFence rail = new RailFence(); //calls railfence class so it can be used
	private static TextScorer textScore; 

	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) //constructor
	{
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
		
	}

	public void run() 
	{
		String plainText = rail.decrypt(cypherText, key); 
		textScore = new TextScorer(QuadGramMap.getMap()); 
		Double score = textScore.getScore(plainText); 
		Resultable r = new Result(plainText, key, score); //gets or creates the result
		
		try
		{
			queue.put(r); 
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
