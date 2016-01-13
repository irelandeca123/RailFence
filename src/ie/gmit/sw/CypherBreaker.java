package ie.gmit.sw;

import ie.gmit.sw.Resultable;

import java.util.concurrent.*;

public class CypherBreaker
{
	private static final int MAX_QUEUE_SIZE = 100; //initialises max que size to 100
	private BlockingQueue<Resultable> queue; 
	private String cypherText;
	
	public CypherBreaker(String cypherText){
		queue = new ArrayBlockingQueue(MAX_QUEUE_SIZE);
		this.cypherText = cypherText;
		
		init(); 
		
	}
	
	public void init(){
		
		for(int i = 2; i<cypherText.length()/2; i++){
			new Thread(new Decryptor(queue, cypherText, i)).start();
		}
		
		Thread t = new Thread(new Score(cypherText.length()/2, queue)); //creates thread 
		try
		{
			Thread.sleep(2000); //puts thread to sleep
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		t.start(); 
	}
}